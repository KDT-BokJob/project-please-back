package com.kdt.please.domain.career.service.response;

import com.kdt.please.domain.career.Career;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CareerInfoResponse(
        Long careerId,
        String job,
        String responsibility,
        LocalDate startedAt,
        LocalDate endedAt,
        String workPerformance,
        String detail
) {
    public static CareerInfoResponse from(Career career){
        return CareerInfoResponse.builder()
                .careerId(career.getCareerId())
                .job(career.getJob())
                .detail(career.getDetail())
                .responsibility(career.getResponsibility())
                .startedAt(career.getStartedAt())
                .endedAt(career.getEndedAt())
                .workPerformance(career.getWorkPerformance())
                .build();
    }
}
