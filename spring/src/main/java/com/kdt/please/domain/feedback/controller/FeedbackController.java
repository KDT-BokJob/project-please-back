package com.kdt.please.domain.feedback.controller;

import com.kdt.please.domain.feedback.service.FeedbackService;
import com.kdt.please.domain.feedback.service.request.FeedbackCreateRequest;
import com.kdt.please.domain.feedback.service.response.FeedbackResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @ApiOperation("피드백 상세 조회")
    @GetMapping("/{feedbackId}")
    public ResponseEntity<FeedbackResponse> getFeedback(@PathVariable("feedbackId") final Long feedbackId) {
        return ResponseEntity.ok(feedbackService.getFeedbackInfo(feedbackId));
    }

    @ApiOperation("피드백 생성")
    @PostMapping("")
    public ResponseEntity<Long> createFeedback(@RequestBody FeedbackCreateRequest feedbackCreateRequest) {
        return ResponseEntity.ok(feedbackService.createFeedback(feedbackCreateRequest));
    }

    @ApiOperation("피드백 목록 조회")
    @GetMapping("/list")
    public ResponseEntity<List<FeedbackResponse>> getFeedbackList() {
        return ResponseEntity.ok(feedbackService.getFeedbackList());
    }
}
