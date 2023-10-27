package com.kdt.please.domain.career.service.request;

import com.kdt.please.domain.resume.Resume;

import java.time.LocalDate;

public record CareerCreateRequest(

        String job,
        String role,
        LocalDate hireDate,
        LocalDate endDate,
        String workPerformance,
        String detailInfo
) {
}
