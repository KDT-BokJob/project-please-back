package com.kdt.please.domain.apply.controller;

import com.kdt.please.domain.apply.service.ApplyService;
import com.kdt.please.domain.apply.service.request.ApplyCreateRequest;
import com.kdt.please.domain.apply.service.request.SelectEmployeeRequest;
import com.kdt.please.domain.apply.service.request.SelectInterviewerRequest;
import com.kdt.please.domain.apply.service.response.ApplyResponse;
import com.kdt.please.global.Status;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    @PostMapping("")
    public ResponseEntity<Long> applyFor(@RequestBody @Valid ApplyCreateRequest applyCreateRequest){
        return ResponseEntity.ok(1L);
    }

    @ApiOperation("지원 상세 정보 조회")
    @GetMapping("/{applyId}")
    public ResponseEntity<ApplyResponse> getApplyInfo(@RequestBody @Valid ApplyResponse applyResponse){
        return ResponseEntity.ok(ApplyResponse.builder()
                .applyId(1L)
                .userId(2L)
                .resumeId(3L)
                .status(Status.APPLIED)
                .recruitId(4L)
                .build());
    }

    @ApiOperation("면접자 선정")
    @PostMapping("/interviewer/{applyId}")
    public ResponseEntity<Long> setInterviewer(@PathVariable final Long applyId, @RequestBody @Valid SelectInterviewerRequest interviewerRequest){
        return ResponseEntity.ok(1L);
    }

    @ApiOperation("근로자 선정")
    @PostMapping("/employee/{applyId}")
    public ResponseEntity<Long> setEmployee(@PathVariable final Long applyId, @RequestBody @Valid SelectEmployeeRequest employeeRequest){
        return ResponseEntity.ok(1L);
    }

    @ApiOperation("지원 내역 조회")
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<ApplyResponse>> getApplyList(@PathVariable final Long userId,
                                                           @RequestParam("page") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        return ResponseEntity.ok(applyService.getApplyList(userId ,pageRequest));
    }

}
