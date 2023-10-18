package com.kdt.please.domain;

import com.kdt.please.config.auth.dto.SessionUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testController(){
        return "hello";
    }

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
