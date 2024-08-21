package com.nc13.springBoard.service;


import com.nc13.springBoard.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final String NAMESPACE = "com.nc13.mappers.BoardMapper";
    //한 페이지의 들어갈 글의 갯수
    private final int PAGE_SIZE = 25;

    @Autowired
    private SqlSession session;

    public List<BoardDTO> selectAll(int pageNo) {
        // pageNo가 1일 때는
        // 0번째 로우부터 25개를 뽑아야 함
        // pageNo가 2일 때엔
        // 25번째부터 로우부터 25개를 뽑아야 함
        // pageNo가 n인경우에는?
        // (n-1)25 번째 로우부터 25개를 뽑아야함

        //  우리가 이번에는 Mapper.xml으로 2가지 값을 넘겨 주어야 함
        // 이 때에는 따로 DTO를 만들어줘도 되지만
        // Map을 넘겨주어도 됨
        HashMap<String, Integer> paraMap = new HashMap<>();
        paraMap.put("startRow", (pageNo - 1) * PAGE_SIZE);
        paraMap.put("size", PAGE_SIZE);

        return session.selectList(NAMESPACE + ".selectAll", paraMap);

    }

    public void insert(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO:" + boardDTO);
        session.insert(NAMESPACE + ".insert", boardDTO);
        System.out.println("insert 후 boardDTO:" + boardDTO);
    }

    public BoardDTO selectOne(int id) {
        return session.selectOne(NAMESPACE + ".selectOne", id);
    }

    public void update(BoardDTO attempt) {
        session.update(NAMESPACE + ".update", attempt);
    }

    public void delete(int id) {
        session.delete(NAMESPACE + ".delete", id);
    }

    public int selectMaxPage() {
        int maxRow = session.selectOne(NAMESPACE + ".selectMaxRow");
        System.out.println(maxRow);
        //글의 총 갯수: maxRow
        // 총 페이지 갯수
        int maxPage = maxRow / PAGE_SIZE;
        System.out.println(maxPage);

        if (maxRow % PAGE_SIZE != 0) {
            maxPage++;
        }
        return maxPage;
    }


}
