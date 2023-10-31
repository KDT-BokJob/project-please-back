package com.kdt.please.domain.company.controller;

import com.kdt.please.domain.company.service.request.CompanyCreateRequest;
import com.kdt.please.domain.company.service.request.CompanyUpdateRequest;
import com.kdt.please.domain.company.service.response.CompanyResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @ApiOperation("기업 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<CompanyResponse> getCompany(@PathVariable Long userId){
        return ResponseEntity.ok(
                CompanyResponse.builder()
                        .companyId(1L)
                        .userId(1L)
                        .businessCode("01200")
                        .name("축산마을")
                        .employeeCount(50)
                        .foreignEmployeeCount(5)
                        .build()
        );
    }

    @ApiOperation("기업 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<CompanyResponse> createCompany(@PathVariable Long userId,
                                                         @RequestBody CompanyCreateRequest companyCreateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("기업 수정")
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long companyId,
                                                         @RequestBody CompanyUpdateRequest companyCreateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("기업 삭제")
    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        return ResponseEntity.ok().build();
    }
}
