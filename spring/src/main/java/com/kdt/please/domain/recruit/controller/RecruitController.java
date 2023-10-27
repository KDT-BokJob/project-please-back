package com.kdt.please.domain.recruit.controller;

import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/recruit")
public class RecruitController {
    /*@GetMapping("/")
    public ResponseEntity<String> getRecruit(){

    }*/

    @PostMapping("/create")
    public ResponseEntity<Void> createRecruit(@RequestBody RecruitCreateRequest recruitCreateRequest){
        return ResponseEntity.ok().build();
    }
}
