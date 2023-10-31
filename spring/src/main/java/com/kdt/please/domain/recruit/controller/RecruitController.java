package com.kdt.please.domain.recruit.controller;

import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import com.kdt.please.domain.recruit.service.response.RecruitResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @ApiOperation("공고 등록")
    @PostMapping("/{companyId}")
    public ResponseEntity<RecruitResponse> createRecruit(@ApiParam(value = "기업ID") @PathVariable(value = "conpanyId") Long conpanyId,
                                              @RequestBody RecruitCreateRequest recruitCreateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 수정")
    @PutMapping("/{postId}")
    public ResponseEntity<RecruitResponse> updateRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId,
                                                @RequestBody RecruitUpdateRequest recruitUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 조회")
    @GetMapping("/{postId}")
    public ResponseEntity<RecruitResponse> getRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId){
        return ResponseEntity.ok(RecruitResponse.builder()
                .recruitId(1L)
                .companyId(1L)
                .job_code("01100")
                .title("농산업 인력 모집")
                .content("힘센 사람 2명 모집")
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusDays(2))
                .salary(1000000)
                .workType("정규직")
                .workLocation("충청북도 ~~~~~~")
                .workDaysWeek(7)
                .workPeriod(12)
                .workStartHour(9)
                .workEndHour(18).build());
    }

    @ApiOperation("공고 삭제")
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 목록 조회")
    @GetMapping("/{companyId}/list")
    public ResponseEntity<RecruitResponse[]> getRecruitList(@ApiParam(value = "기업ID") @PathVariable(value = "companyId") Long companyId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 키워드 조회")
    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<RecruitResponse[]> getRecruitByKeyword(@ApiParam(value = "키워드") @PathVariable String keyword){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("직업코드로 공고 조회")
    @GetMapping("/job-code/{job_code}")
    public ResponseEntity<RecruitResponse[]> getRecruitByJobCode(@ApiParam(value = "키워드") @PathVariable String job_code){
        return ResponseEntity.ok().build();
    }
}
