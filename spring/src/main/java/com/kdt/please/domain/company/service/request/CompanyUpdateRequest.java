package com.kdt.please.domain.company.service.request;

import javax.validation.constraints.NotNull;

public record CompanyUpdateRequest(
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
}
