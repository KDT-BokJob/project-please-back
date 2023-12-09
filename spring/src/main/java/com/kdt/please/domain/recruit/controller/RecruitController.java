package com.kdt.please.domain.recruit.controller;

import com.kdt.please.domain.recruit.service.RecruitService;
import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import com.kdt.please.domain.recruit.service.response.RecruitApplyResponse;
import com.kdt.please.domain.recruit.service.response.RecruitResponse;
import com.kdt.please.domain.recruit.service.response.RecruitSimpleResponse;
import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    private final RecruitService recruitService;

    @ApiOperation("공고 등록")
    @PostMapping("")
    public ResponseEntity<Long> createRecruit(@RequestPart(value = "dto") @Valid RecruitCreateRequest recruitCreateRequest,
                                              @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(recruitService.createRecruit(recruitCreateRequest, file));
    }

    @ApiOperation("공고 수정")
    @PutMapping("/{recruitId}")
    public ResponseEntity<RecruitResponse> updateRecruit(@ApiParam(value = "공고 ID") @PathVariable Long recruitId,
                                                         @RequestPart(value = "dto") @Valid RecruitUpdateRequest recruitUpdateRequest,
                                                         @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        RecruitResponse recruitResponse = recruitService.updateRecruit(recruitId, recruitUpdateRequest, file);
        return ResponseEntity.ok(recruitResponse);
    }

    @ApiOperation("공고 조회")
    @GetMapping("/{recruitId}")
    public ResponseEntity<RecruitResponse> getRecruit(@ApiParam(value = "공고 ID") @PathVariable Long recruitId){
        return ResponseEntity.ok(recruitService.getRecruit(recruitId));
    }

    @ApiOperation("공고 삭제")
    @DeleteMapping("/{recruitId}")
    public ResponseEntity<Void> deleteRecruit(@ApiParam(value = "공고 ID") @PathVariable Long recruitId){
        recruitService.deleteRecruit(recruitId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("기업이 올린 공고 목록 조회")
    @GetMapping("/company/list/{companyId}")
    public ResponseEntity<List<RecruitSimpleResponse>> getRecruitList(@ApiParam(value = "기업 ID") @PathVariable(value = "companyId") Long companyId){

        return ResponseEntity.ok(recruitService.getRecruitListByCompany(companyId));
    }

    @ApiOperation("구인자가 올린 공고 목록 조회")
    @GetMapping("/recruiter/list/{userId}")
    public ResponseEntity<List<RecruitApplyResponse>> getMyRecruitList(@ApiParam(value = "구인자 ID") @PathVariable(value = "userId") Long userId){

        return ResponseEntity.ok(recruitService.getRecruitListByRecruiter(userId));
    }

    @ApiOperation("전체 공고 목록 조회")
    @GetMapping("/list")
    public ResponseEntity<List<RecruitSimpleResponse>> getRecruitListAll(@RequestParam("page") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        return ResponseEntity.ok(recruitService.getRecruitList(pageRequest));
    }

    @ApiOperation("공고 검색")
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<RecruitSimpleResponse>> getRecruitByKeyword(@ApiParam(value = "키워드") @PathVariable String keyword){
        return ResponseEntity.ok(recruitService.searchByKeyword(keyword));
    }

    @ApiOperation("비자로 공고 조회 - 미완성")
    @GetMapping("/visa/{visa}")
    public ResponseEntity<RecruitResponse[]> getRecruitByJobCode(@ApiParam(value = "비자") @PathVariable String visa){
        // 비자로 직업코드들을 조회하고
        // 해당 직업코드들의 공고 목록을 조회
        return ResponseEntity.ok().build();
    }
}