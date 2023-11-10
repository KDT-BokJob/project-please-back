package com.kdt.please.domain.company.service.request;

import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.recruit.Recruit;
import lombok.Getter;

import javax.validation.constraints.NotNull;


public record CompanyCreateRequest(
        // 회원 ID
        @NotNull
        Long userId,
        // 사업자 등록 번호
        @NotNull
        String businessCode,
        // 기업명
        @NotNull
        String name,
        // 사원 수
        @NotNull
        int employeeCount,
        // 외국인 사원 수
        @NotNull
        int foreignEmployeeCount,
        @NotNull
        String phone,
        @NotNull
        String address,
        @NotNull
        boolean isVisaTransform
) {
        public Company toEntity(){
                return Company.builder()
                        .businessCode(businessCode)
                        .name(name)
                        .address(address)
                        .employeeCount(employeeCount)
                        .foreignEmployeeCount(foreignEmployeeCount)
                        .phone(phone)
                        .address(address)
                        .isVisaTransform(isVisaTransform)
                        .build();
        }
}