package com.kdt.please.domain.certification.controller;

import com.kdt.please.domain.certification.service.CertificationService;
import com.kdt.please.domain.certification.service.request.CertificationCreateRequest;
import com.kdt.please.domain.certification.service.request.CertificationUpdateRequest;
import com.kdt.please.domain.certification.service.response.CertificationResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/certs")
@RequiredArgsConstructor
@Controller
public class CertificationController {
    private final CertificationService certificationService;

    @ApiOperation("자격증 등록")
    @PostMapping("")
    public ResponseEntity<Long> createCareer(@RequestBody @Valid CertificationCreateRequest req){
        return ResponseEntity.ok(certificationService.createCert(req));
    }

    @ApiOperation("자격증 상세 조회")
    @GetMapping("/{certificationId}")
    public ResponseEntity<CertificationResponse> getCareer(@PathVariable final Long certificationId){
        return ResponseEntity.ok(certificationService.getCertInfo(certificationId));
    }

    @ApiOperation("내 자격증 리스트 조회")
    @GetMapping("/my/{resumeId}")
    public ResponseEntity<List<CertificationResponse>> getMyCareer(@PathVariable final Long resumeId){
        return ResponseEntity.ok(certificationService.getMyCerts(resumeId));
    }

    @ApiOperation("자격증 수정")
    @PutMapping("/{certificationId}")
    public ResponseEntity<CertificationResponse> updateCareer(@PathVariable final Long certificationId, @RequestBody @Valid CertificationUpdateRequest req){
        return ResponseEntity.ok(certificationService.updateCert(certificationId, req));
    }

    @ApiOperation("자격증 삭제")
    @DeleteMapping("/{certificationId}")
    public ResponseEntity<Void> deleteCareer(@PathVariable final Long certificationId){
        certificationService.deleteCert(certificationId);
        return ResponseEntity.ok().build();
    }
}
