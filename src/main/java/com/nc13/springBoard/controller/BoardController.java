package com.nc13.springBoard.controller;

import com.nc13.springBoard.model.BoardDTO;
import com.nc13.springBoard.model.ReplyDTO;
import com.nc13.springBoard.model.UserDTO;
import com.nc13.springBoard.service.BoardService;
import com.nc13.springBoard.service.ReplyService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/board/")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("showAll")
    public String moveToFirstPage() {
        return "redirect:/board/showAll/1";
    }

    @GetMapping("showAll/{pageNo}")
    public String showAll(Model model, @PathVariable int pageNo) {
        //가장 마지막 페이지의 번호
        int maxPage = boardService.selectMaxPage();
        model.addAttribute("maxPage", maxPage);
        // 우리가 이제 pageNo를 사용하여
        // 시작 페이지 번호
        // 끝 페이지 번호
        // 를 계산해 주어야 한다.
        // 이때에는 크게 3가지가 있다.

        //1. 현재 페이지가 3이하일 경우
        // 시작:1, 끝:5

        //2. 현재 페이지가 최대 페이지 -2 이상일 경우
        // 시작: 최대 페이지-4 끝: 최대페이지

        //3. 그 외
        // 시작: 현재 페이지-2 끝: 현재 페이지 +2 >> 이 정보를 데이터베이스한테 물어봐야 됨> 서비스랑 매퍼를 통해

        //시작 페이지
        int startPage;

        //끝 페이지
        int endPage;

        if (maxPage < 5) {
            startPage = 1;
            endPage = maxPage;
        } else if (pageNo <= 3) {
            startPage = 1;
            endPage = 5;
        } else if (pageNo >= maxPage - 2) {
            startPage = maxPage - 4;
            endPage = maxPage;
        } else {
            startPage = pageNo - 2;
            endPage = pageNo + 2;
        }

        model.addAttribute("curPage", pageNo);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        List<BoardDTO> list = boardService.selectAll(pageNo);
        model.addAttribute("list", list);


        return "board/showAll";
    }

    @GetMapping("write")
    public String showWrite() {

        return "board/write";
    }

    @PostMapping("write")// 파일이 멀티일 경우에는 배열로 만들어줌
    //정말 글 쓰기의 내용들
    public String write(BoardDTO boardDTO, Authentication authentication) {
        UserDTO logIn = (UserDTO)authentication.getPrincipal();
        boardDTO.setWriterId(logIn.getId());

            boardService.insert(boardDTO);

        return "redirect:/board/showOne/" + boardDTO.getId();
    }

    //우리가 주소창에 있는 값을 매핑해줄 수 있다.
    @GetMapping("showOne/{id}")
    public String showOne(HttpSession session, @PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        //자바에서 jsp로 넘겨주려고 사용하는 모델클래스
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }

        BoardDTO boardDTO = boardService.selectOne(id);

        if (boardDTO == null) {
            redirectAttributes.addFlashAttribute("message", "해당 글 번호는 유효하지 않습니다.");
            return "redirect:/showMessage";
        }

        List<ReplyDTO> replyList = replyService.selectAll(id);

        model.addAttribute("boardDTO", boardDTO);
        model.addAttribute("replyList", replyList);

        return "board/showOne";
    }

    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable int id, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }
        BoardDTO boardDTO = boardService.selectOne(id);

        if (boardDTO == null) {
            redirectAttributes.addFlashAttribute("message", "존재하지 않는 글의 번호입니다.");
            return "redirect:/showMessage";
        }

        if (boardDTO.getWriterId() != logIn.getId()) {
            redirectAttributes.addFlashAttribute("message", "권한이 없습니다.");
            return "redirect:/showMessage";
        }
        model.addAttribute("boardDTO", boardDTO);
        return "board/upudate";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, HttpSession session, RedirectAttributes redirectAttributes, BoardDTO attempt) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }

        BoardDTO boardDTO = boardService.selectOne(id);
        if (boardDTO == null) {
            redirectAttributes.addFlashAttribute("message", "유효하지 않은 글 번호입니다.");
        }

        if (boardDTO.getWriterId() != logIn.getId()) {
            redirectAttributes.addFlashAttribute("message", "권한이 없습니다.");
            return "redirect:/showMessage";
        }

        attempt.setId(id);

        boardService.update(attempt);

        return "redirect:/board/showOne/" + id;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, HttpSession session, RedirectAttributes redirectAttributes) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }

        BoardDTO boardDTO = boardService.selectOne(id);
        if (boardDTO == null) {
            redirectAttributes.addFlashAttribute("messga", "존재하지 않는 글 번호");
            return "redirect:/showMessage";
        }

        if (boardDTO.getWriterId() != logIn.getId()) {
            redirectAttributes.addFlashAttribute("message", "권한이 없습니다.");
            return "redirect:/showMessage";
        }

        boardService.delete(id);
        return "redirect:/board/showAll";
    }
    @ResponseBody
    // 일반 컨트롤러 안에 Restful ApI로써,
    // JSON의 결과값을 리턴해야하는 경우
    // 맵핑 어노테이션 위에 ResponseBody 어노테이션을 붙여준다.
    // 어떤 뷰로 이동해라 가 아닌, 레스트풀을 쓴것처럼 맵이 그대로 전송됨
    // 씨케이에서 그림을 올렸을 때, 업로되는 과정에 그 결과에 대한 것을 리턴을 할 때 중추적인 역할을 함
    // 업로드가 잘 되었습니다, 라고 말을 해줌.
    @PostMapping("uploads")
    public Map<String, Object> uploads(MultipartHttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();

        String uploadPath= "";

        MultipartFile file = request.getFile("upload");
        String filename = file.getOriginalFilename();
        String extention = filename.substring(filename.lastIndexOf("."));
        String uploadName = UUID.randomUUID() + extention;
        //(파일이 덮어씌우기가 되려고 할 때) 확장자 이름에 랜덤하게 고유한 이름이 지어짐.

        String realPath = request.getServletContext().getRealPath("/board/uploads/");
        //현재 돌아가는 톰캣의 실제 주소창을 찾는 방법
        Path realDir = Paths.get(realPath);
        if(!Files.exists(realDir)){
            try{
                Files.createDirectories(realDir);
            }catch (IOException e ){
                e.printStackTrace();
            }
        }
        //업로드할 폴더 생성한 것

        File uploadFile = new File(realPath + uploadName);
        try{
            file.transferTo(uploadFile);
        }catch (IOException e){
            System.out.println("파일 전송 중 에러");
            e.printStackTrace();
        }

        uploadPath = "/board/uploads/" + uploadName;

        resultMap.put("uploaded", true);
        resultMap.put("url", uploadPath);
        return resultMap;
    }


}
