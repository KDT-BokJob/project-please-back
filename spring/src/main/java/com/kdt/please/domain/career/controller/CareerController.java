package com.kdt.please.domain.career.controller;

import com.kdt.please.domain.career.service.request.CareerCreateRequest;
import com.kdt.please.domain.career.service.request.CareerUpdateRequest;
import com.kdt.please.domain.career.service.response.CareerInfoResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/careers")
public class CareerController {

    @ApiOperation("경력 등록")
    @PostMapping("")
    public ResponseEntity<Long> createCareer(@RequestBody @Valid CareerCreateRequest req){
        return ResponseEntity.ok(1L);
    }

    @ApiOperation("경력 조회")
    @GetMapping("/{careerId}")
    public ResponseEntity<CareerInfoResponse> getCareer(@PathVariable final Long careerId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("경력 수정")
    @PutMapping("/{careerId}")
    public ResponseEntity<Long> updateCareer(@PathVariable final Long careerId, @RequestBody @Valid CareerUpdateRequest req){
        return ResponseEntity.ok(1L);
    }

    @ApiOperation("경력 삭제")
    @DeleteMapping("/{careerId}")
    public ResponseEntity<Void> deleteCareer(@PathVariable final Long careerId){
        return ResponseEntity.ok().build();
    }
}
