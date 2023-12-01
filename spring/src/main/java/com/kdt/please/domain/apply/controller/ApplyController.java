package com.kdt.please.domain.apply.controller;

import com.kdt.please.domain.apply.service.ApplyService;
import com.kdt.please.domain.apply.service.request.ApplyCreateRequest;
import com.kdt.please.domain.apply.service.response.ApplyResponse;
import com.kdt.please.domain.apply.service.response.RecruitApplyListResponse;
import com.kdt.please.domain.apply.service.response.UserApplyListResponse;
import com.kdt.please.global.Status;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apply")
public class ApplyController {

    private final ApplyService applyService;

    @Autowired
    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @ApiOperation("공고에 지원")
    @PostMapping("/recruitId/{recruitId}")
    public ResponseEntity<ApplyResponse> applyFor(@ApiParam("공고 ID") @PathVariable final Long recruitId,
                                                  @RequestBody @Valid ApplyCreateRequest applyCreateRequest){
        return ResponseEntity.ok(
                applyService.createApply(recruitId, applyCreateRequest)
        );
    }

    @ApiOperation("지원 정보 조회")
    @GetMapping("/{applyId}")
    public ResponseEntity<ApplyResponse> getApplyInfo(@ApiParam("지원 ID") @PathVariable final Long applyId){
        return ResponseEntity.ok(
                applyService.getApply(applyId)
        );
    }

    @ApiOperation("면접자 선정")
    @PostMapping("/{applyId}/interviewer")
    public ResponseEntity<ApplyResponse> setInterviewer(@ApiParam("지원 ID") @PathVariable final Long applyId){
        return ResponseEntity.ok(
                applyService.updateApply(applyId, Status.INTERVIEW_SELECTED)
        );
    }

    @ApiOperation("이력서 탈락")
    @PostMapping("/{applyId}/interviewer/failure")
    public ResponseEntity<ApplyResponse> setResumeReject(@ApiParam("지원 ID") @PathVariable final Long applyId){
        return ResponseEntity.ok(
                applyService.updateApply(applyId, Status.RESUME_REJECTED)
        );
    }

    @ApiOperation("근로자 선정")
    @PostMapping("/{applyId}/employee")
    public ResponseEntity<ApplyResponse> setFinalPassed(@ApiParam("지원 ID") @PathVariable final Long applyId){
        return ResponseEntity.ok(
                applyService.updateApply(applyId, Status.FINAL_PASSED)
        );
    }

    @ApiOperation("근로자 최종 탈락")
    @PostMapping("/{applyId}/employee/failure")
    public ResponseEntity<ApplyResponse> setFinalReject(@ApiParam("지원 ID") @PathVariable final Long applyId){
        return ResponseEntity.ok(
                applyService.updateApply(applyId, Status.FINAL_REJECTED)
        );
    }

    @ApiOperation("한 유저의 지원 내역 조회")
    @GetMapping("/userId/{userId}/list")
    public ResponseEntity<List<RecruitApplyListResponse>> getApplyListByUserId(@ApiParam("유저 ID") @PathVariable final Long userId,
                                                                               @ApiParam("페이지 인덱스") @RequestParam("page") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        return ResponseEntity.ok(applyService.getApplyListByUserId(userId ,pageRequest));
    }

    @ApiOperation("한 공고의 지원 내역 조회")
    @GetMapping("/recruitId/{recruitId}/list")
    public ResponseEntity<List<UserApplyListResponse>> getApplyListByRecruitId(@ApiParam("공고 ID") @PathVariable final Long recruitId,
                                                                               @ApiParam("페이지 인덱스") @RequestParam("page") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        return ResponseEntity.ok(applyService.getApplyListByRecruitId(recruitId ,pageRequest));
    }

}