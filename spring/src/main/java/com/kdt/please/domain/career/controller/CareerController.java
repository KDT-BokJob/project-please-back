package com.kdt.please.domain.career.controller;

import com.kdt.please.domain.career.service.request.CareerCreateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
public class CareerController {

    @ApiOperation("경력 등록")
    @PostMapping("/{resumeId}")
    public ResponseEntity<Void> createCareer(@PathVariable final Long resumeId, @RequestBody CareerCreateRequest req){
        return ResponseEntity.ok().build();
    }
}
