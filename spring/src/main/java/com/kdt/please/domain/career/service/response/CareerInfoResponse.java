package com.kdt.please.domain.career.service.response;

import java.time.LocalDate;

public record CareerInfoResponse(
        Long id,
        String job,
        String responsibility,
        LocalDate startedAt,
        LocalDate endedAt,
        String workPerformance,
        String detail
) {
}
