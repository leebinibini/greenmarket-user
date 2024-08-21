package com.nc13.springBoard.config;

import com.nc13.springBoard.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.AbstractList;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserAuthService userAuthService) throws Exception {


        httpSecurity
                //Cross Site Request Forgery 방지
                .csrf(AbstractHttpConfigurer::disable)
                // URL 별 권한 설정
                .authorizeHttpRequests((authorize) -> authorize
                        //WEB - UNF 폴더 안의 VIEWS안의 모든 JSP파일은 누구든 접근 가능
                        // 별이 하나면 파일안에 있는 직속  파일들만, 그 파일 안에 있는 하위폴더까지 포함한다.
                        .requestMatchers("/WEB-INF/**").permitAll()
                        // images 폴더와 해당 폴더 안의 모든 파일은 누구든 접근 가능
                        .requestMatchers("/images/**").permitAll()

                        .requestMatchers("/", "/user/*").permitAll()

                        // /board/write는 admin 역할을 가진 사용자만 접근 가능
                        // 만약에 여러 명을 접근 가능하게 하고 싶다면 hasAnyRole해주면 된다.
                        .requestMatchers("/board/write").hasAnyAuthority("ROLE_ADMIN")


                        //위의 경우가 아닌 모든 url은 로그인한 사용자만 접근 가능
                        .anyRequest().authenticated()
                )
                //커스텀 폼 로그인 설정
                .formLogin((formLogIn) -> formLogIn
                        // 로그인에서 사용할 페이지 설정
                        .loginPage("/")
                        // 로그인 페이지에서 username을 어떤 name 어트리뷰트로 넘겨줄지 설정
                        .usernameParameter("username")
                        // 로그인 페이지에서 password 를 어던 name 어트리뷰트로 넘겨줄 지 설정
                        .passwordParameter("password")
                        //로그인 성공 시 이동할 페이지
                        .defaultSuccessUrl("/board/showAll/1")
                        //로그인 처리 URL
                        .loginProcessingUrl("/user/auth"))
                //내가 만든 userAuthService 등록
                .userDetailsService(userAuthService);

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}



