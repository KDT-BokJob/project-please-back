package com.kdt.please.domain;

import com.kdt.please.config.auth.LoginUser;
import com.kdt.please.config.auth.dto.SessionUser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class TestController {

    @GetMapping("/test")
    public String testController(){
        return "main";
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<SessionUser> index(Model model, @LoginUser SessionUser user) {

        if(user == null)
            return ResponseEntity.ok(null);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
