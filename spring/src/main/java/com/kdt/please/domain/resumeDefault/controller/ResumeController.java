package com.kdt.please.domain.resumeDefault.controller;

import com.kdt.please.domain.resumeDefault.service.request.ResumeCreateRequest;
import com.kdt.please.domain.resumeDefault.service.request.ResumeUpdateReq;
import com.kdt.please.domain.resumeDefault.service.response.ResumeResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @ApiOperation("이력서 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<Void> createResume(@PathVariable final Long userId, @RequestBody @Valid ResumeCreateRequest resumeCreateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("이력서 조회")
    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeResponse> getResume(@PathVariable final Long resumeId){
        return ResponseEntity.ok(ResumeResponse.builder()
                .resumeId(1L)
                .nationality("vietnam")
                .firstName("lee")
                .middleName("joo")
                .lastName("hee")
                .koreanProficiency(3)
                .coverLetter("hihihi")
                .degree("bachelor's degree")
                .isExperienced(false)
                .isDisabled(false).build());
    }

    @ApiOperation("이력서 수정")
    @PutMapping("/{resumeId}")
    public ResponseEntity<ResumeResponse> updateResume(@PathVariable final Long resumeId, @RequestBody @Valid ResumeUpdateReq req){
        return ResponseEntity.ok().build();
    }


    @ApiOperation("이력서 삭제")
    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteResume(@PathVariable final Long resumeId){
        return ResponseEntity.ok().build();
    }
}
