package com.kdt.please.domain.resume.controller;

import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@RestController("/resumes")
public class ResumeController {

    @PostMapping
    public ResponseEntity<Void> createResume(@RequestBody ResumeCreateRequest resumeCreateRequest){
        return ResponseEntity.ok().build();
    }

}
