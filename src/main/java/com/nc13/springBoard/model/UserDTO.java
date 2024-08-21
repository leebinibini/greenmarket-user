package com.nc13.springBoard.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
//인터페이스는 사용자를 뜻하는 것, 반드시 getAuthorities 이것이 필요함
public class UserDTO implements UserDetails {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String role;
    private List<GrantedAuthority> authorities;
    //롤 같은 경우는 역할의 이름을 지정하는 게 가능하고 아래에는 추가적으로 add, write 등 권한, 직책 설정이다.


    @Override
    public List<GrantedAuthority> getAuthorities(){
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
    // GrantedAuthority: 스트링으로 권한을 설정을 하려는데 (받는 걸 스트링으로 받기 위해 ) 내부적으로 직렬화로 저장을 하는데(파일식)
    // 어떤 사용자한테 무슨 권한인지 확인을 하는 게 중요하니까 직렬화로 검색을 하는 게 빨라서
    // 따로 데이터타입을 만들어 놓음

}
