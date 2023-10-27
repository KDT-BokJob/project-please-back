package com.kdt.please.domain.career.controller;

import com.kdt.please.domain.career.Career;
import com.kdt.please.domain.career.service.request.CareerCreateRequest;
import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/careers")
public class CareerController {

    @PostMapping
    public ResponseEntity<Void> createCareer(@RequestBody CareerCreateRequest careerCreateRequest){
        return ResponseEntity.ok().build();
    }
}
