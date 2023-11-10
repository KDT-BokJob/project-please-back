package com.kdt.please.domain.company.controller;

import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.company.service.CompanyService;
import com.kdt.please.domain.company.service.request.CompanyCreateRequest;
import com.kdt.please.domain.company.service.request.CompanyUpdateRequest;
import com.kdt.please.domain.company.service.response.CompanyResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @ApiOperation("기업 조회")
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompany(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.getCompany(companyId));
    }

    @ApiOperation("기업 등록")
    @PostMapping("/")
    public ResponseEntity<Long> createCompany(@RequestBody @Valid CompanyCreateRequest companyCreateRequest){
        // sessionUser가 구인자인지 확인해야 함
        return ResponseEntity.ok(companyService.createCompany(companyCreateRequest));
    }

    @ApiOperation("기업 수정")
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long companyId,
                                                         @RequestBody @Valid CompanyUpdateRequest companyCreateRequest){

        return ResponseEntity.ok().build();
    }

    @ApiOperation("기업 삭제")
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId){
        // sessionUser가 구인자인지, 기업을 등록한 사람인지 확인해야 함
        companyService.deleteCompany(companyId);
        return ResponseEntity.ok().build();
    }
}