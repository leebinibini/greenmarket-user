package com.nc13.springBoard.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ErrorController {
    @GetMapping("/showMessage")
    //모델 어트리뷰트로 유저에서 보낸 걸 찾는 거임. 모델은 jsp로 보낼 때 사용해야 함
    public String showError(@ModelAttribute("message")String message, Model model){


        model.addAttribute("message", message);

        return "showMessage";
    }
}
