package com.kdt.please.domain.filter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    @ApiOperation("업종명 검색")
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<String>> searchJobName(@PathVariable String keyword){
        return ResponseEntity.ok(jobService.getJobNameList(keyword));
    }

    @ApiOperation("해당 업종에 취업할 수 있는 비자 목록 조회")
    @GetMapping("/visa/{keyword}")
    public ResponseEntity<List<String>> getVisaListByJobName(@PathVariable String keyword){
        return ResponseEntity.ok(jobService.getVisaList(keyword));
    }

    @ApiOperation("특정 비자로 취업할 수 있는 업종 리스트 조회 - 최대 5개")
    @GetMapping("/jobName/{keyword}")
    public ResponseEntity<List<String>> getJobByVisa(@PathVariable String keyword){
        return ResponseEntity.ok(jobService.getJobNamesByVisa(keyword));
    }
}