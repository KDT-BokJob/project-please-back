package com.kdt.please.domain.resume.controller;

import com.kdt.please.domain.resume.service.ResumeService;
import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import com.kdt.please.domain.resume.service.request.ResumeDraftRequest;
import com.kdt.please.domain.resume.service.request.ResumeUpdateRequest;
import com.kdt.please.domain.resume.service.response.ResumeDraftResponse;
import com.kdt.please.domain.resume.service.response.ResumeResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @ApiOperation("이력서 등록")
    @PostMapping("/create/{userId}")
    public ResponseEntity<Long> createResume(@PathVariable final Long userId,
                                             @RequestPart(value = "dto") @Valid ResumeCreateRequest resumeCreateRequest,
                                             @RequestPart(value = "image", required = false) MultipartFile image,
                                             @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {

        return ResponseEntity.ok(resumeService.createResume(userId, resumeCreateRequest, image, file));
    }

    @ApiOperation("이력서 임시저장")
    @PostMapping("/saveDraft/{userId}")
    public ResponseEntity<Long> saveDraft(@PathVariable final Long userId,
                                          @RequestPart(value = "dto")ResumeDraftRequest resumeDraftRequest,
                                          @RequestPart(value = "image", required = false) MultipartFile image,
                                          @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(resumeService.createDraftResume(userId, resumeDraftRequest, image, file));
    }

    @ApiOperation(value = "임시저장된 이력서 상세정보 조회", notes = "없으면 null 반환")
    @GetMapping("/draft/{userId}")
    public ResponseEntity<ResumeDraftResponse> hasDraftResume(@PathVariable final Long userId){
        return ResponseEntity.ok(resumeService.getDraftResume(userId));
    }

    @ApiOperation("이력서 상세 조회")
    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeResponse> getResume(@PathVariable final Long resumeId){
        return ResponseEntity.ok(resumeService.getResumeInfo(resumeId));
    }

    @ApiOperation("이력서 수정")
    @PutMapping("/{resumeId}")
    public ResponseEntity<ResumeResponse> updateResume(@PathVariable final Long resumeId,
                                                       @RequestPart(value = "dto") @Valid ResumeUpdateRequest req,
                                                       @RequestPart(value = "image", required = false) MultipartFile image,
                                                       @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {

        return ResponseEntity.ok(resumeService.updateResume(resumeId, req, image, file));
    }

    @ApiOperation("이력서 삭제")
    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteResume(@PathVariable final Long resumeId){
        resumeService.deleteResume(resumeId);
        return ResponseEntity.ok().build();
    }
}