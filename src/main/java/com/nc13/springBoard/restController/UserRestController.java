package com.nc13.springBoard.restController;


import com.nc13.springBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserRestController {
    @Autowired
    UserService userService;
//어떠한 값 또는 객체를 리턴해주는 것이 목표인 컨트롤러이다.
    @GetMapping("validateUsername")
    public Map<String, Object> validateUsername(String username) {
        Map<String, Object> resultMap = new HashMap<>();
        boolean result = userService.validateUsername(username);

        System.out.println(result);


        if (result) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }


        return resultMap;
    }
}
