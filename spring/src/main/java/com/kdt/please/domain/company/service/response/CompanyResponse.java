package com.kdt.please.domain.company.service.response;

import com.kdt.please.domain.company.Company;
import lombok.Builder;

@Builder
public record CompanyResponse(
        // 기업 ID
        Long companyId,
        // 회원 ID
        Long userId,
        // 사업자 등록 번호
        String businessCode,
        // 기업명
        String name,
        String phone,
        String address,
        boolean isVisaTransform,
        // 사원 수
        int employeeCount,
        // 외국인 사원 수
        int foreignEmployeeCount
) {
    public static CompanyResponse from(Company company){
        return CompanyResponse.builder()
                .companyId(company.getCompanyId())
                .userId(company.getUser().getUserId())
                .businessCode(company.getBusinessCode())
                .employeeCount(company.getEmployeeCount())
                .name(company.getName())
                .foreignEmployeeCount(company.getForeignEmployeeCount())
                .businessCode(company.getBusinessCode())
                .phone(company.getPhone())
                .address(company.getAddress())
                .isVisaTransform(company.isVisaTransform())
                .build();
    }
}
