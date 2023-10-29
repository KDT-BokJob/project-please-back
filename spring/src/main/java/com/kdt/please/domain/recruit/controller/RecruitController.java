package com.kdt.please.domain.recruit.controller;

import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @ApiOperation("공고 등록")
    @PostMapping("/{companyId}")
    public ResponseEntity<Void> createRecruit(@ApiParam(value = "기업ID") @PathVariable(value = "conpanyId") Long conpanyId,
                                              @RequestBody RecruitCreateRequest recruitCreateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 수정")
    @PutMapping("/{postId}")
    public ResponseEntity<String> updateRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId,
                                                @RequestBody RecruitUpdateRequest recruitUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 조회")
    @GetMapping("/{postId}")
    public ResponseEntity<String> getRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고 삭제")
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteRecruit(@ApiParam(value = "공고ID") @PathVariable(value = "postId") Long postId){
        return ResponseEntity.ok().build();
    }
}
