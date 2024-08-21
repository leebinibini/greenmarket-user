package com.nc13.springBoard.controller;

import jakarta.servlet.http.HttpSession;
import com.nc13.springBoard.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nc13.springBoard.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller


//유저로 시작하는 주소로 보내고 싶으면 리퀘스트 매핑에 저렇게 붙이면 된다.
@RequestMapping("/user/")
public class UserController {
    // 실제 SQL 통신을 담당할 Service 객체
    @Autowired
    private UserService userService;

    //비밀번호를 암호화해서 저장하려고 한다. 회원가입할 때!
    @Autowired
    private BCryptPasswordEncoder encoder;



//    @PostMapping("auth")
//    public String auth(UserDTO userDTO, HttpSession session){
//        System.out.println("userController.auth()");
//        UserDTO result = userService.auth(userDTO);
//        if(result != null){
//            //로그인 성공!
//            session.setAttribute("logIn", result);
//            return "redirect:/board/showAll";
//        }
//        return "redirect:/";
//    }
    @GetMapping("register")
    public String showRegister() {
        return "user/register";
    }


    @PostMapping("register")
    public String register(UserDTO userDTO, RedirectAttributes redirectAttributes) {
        if (userService.validateUsername(userDTO.getUsername())) {
            userDTO.setPassword(encoder.encode(userDTO.getPassword()));
            userService.register(userDTO);
            System.out.println("회원가입 성공!");
        } else {
            //회원가입 실패 매세지 전송
            // 회원가입 실패 시 우리가 URL을 /error라는 곳으로 전송을 해주되.
            // 해당 페이지에서 무슨 에러인지 알 수 있도록
            // 메세지 내용을 여기서 담아서 보낸다.
            // 만약 다른 url로 이동을 할 때 어떠한 값을 보내주어야 하는  경우
            // RedirectAttributes라는 것을 사용한다.
            redirectAttributes.addFlashAttribute("message", "중복된 아이디로는 가입하실 수 없습니다.");

            return "redirect:/showMessage";
        }

        return "redirect:/";
    }
}

