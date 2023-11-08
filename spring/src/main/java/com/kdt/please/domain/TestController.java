package com.kdt.please.domain;

import com.kdt.please.config.auth.dto.SessionUser;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testController(){
        return "hello";
    }

    @GetMapping("/")
    public ResponseEntity<SessionUser> index(Model model, HttpSession session) {
        SessionUser user = (SessionUser) session.getAttribute("user");

        if(user == null)
            return ResponseEntity.ok(null);

        return ResponseEntity.ok(user);
    }
}
