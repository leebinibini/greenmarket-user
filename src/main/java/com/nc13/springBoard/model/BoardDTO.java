package com.nc13.springBoard.model;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private Date entryDate;
    private Date modifyDate;
    private int writerId;
    private String nickname;
}
//마이 바티스는 클래스의 필드 이름과 데이터베이스의 컬럼명이 같은 경우에 넣어줌
// 모든 컬럼명을 같은 이름을 준다?! 그럴바엔 마이바티스를 안 쓰겠다!