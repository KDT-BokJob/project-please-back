package com.kdt.please.domain.company.service.response;

public record CompanyResponse(
        // 기업 ID
        Long companyId,
        // 회원 ID
        Long userId,
        // 사업자 등록 번호
        String businessCode,
        // 기업명
        String name,
        // 사원 수
        int employeeCount,
        // 외국인 사원 수
        int foreignEmployeeCount
) {
}
