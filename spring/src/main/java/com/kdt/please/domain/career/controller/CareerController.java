package com.kdt.please.domain.career.controller;

import com.kdt.please.domain.career.service.CareerService;
import com.kdt.please.domain.career.service.request.CareerCreateRequest;
import com.kdt.please.domain.career.service.request.CareerUpdateRequest;
import com.kdt.please.domain.career.service.response.CareerInfoResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/careers")
public class CareerController {
    private final CareerService careerService;

    @ApiOperation("경력 등록")
    @PostMapping("")
    public ResponseEntity<Long> createCareer(@RequestBody @Valid CareerCreateRequest req){
        return ResponseEntity.ok(careerService.createCareer(req));
    }

    @ApiOperation("경력 상세 조회")
    @GetMapping("/{careerId}")
    public ResponseEntity<CareerInfoResponse> getCareer(@PathVariable final Long careerId){
        return ResponseEntity.ok(careerService.getCareerInfo(careerId));
    }

    @ApiOperation("내 경력 리스트 조회")
    @GetMapping("/my/{resumeId}")
    public ResponseEntity<List<CareerInfoResponse>> getMyCareer(@PathVariable final Long resumeId){
        return ResponseEntity.ok(careerService.getMyCareersByResumeId(resumeId));
    }

    @ApiOperation("경력 수정")
    @PutMapping("/{careerId}")
    public ResponseEntity<CareerInfoResponse> updateCareer(@PathVariable final Long careerId, @RequestBody @Valid CareerUpdateRequest req){
        return ResponseEntity.ok(careerService.updateCareer(careerId, req));
    }

    @ApiOperation("경력 삭제")
    @DeleteMapping("/{careerId}")
    public ResponseEntity<Void> deleteCareer(@PathVariable final Long careerId){
        careerService.deleteCareer(careerId);
        return ResponseEntity.ok().build();
    }
}
