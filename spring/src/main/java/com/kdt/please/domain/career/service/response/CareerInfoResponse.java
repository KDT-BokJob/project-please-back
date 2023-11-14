package com.kdt.please.domain.career.service.response;

import com.kdt.please.domain.career.Career;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CareerInfoResponse(
        Long careerId,
        String companyName,
        String responsibility,
        LocalDate startedAt,
        LocalDate endedAt
) {
    public static CareerInfoResponse from(Career career){
        return CareerInfoResponse.builder()
                .careerId(career.getCareerId())
                .companyName(career.getCompanyName())
                .responsibility(career.getResponsibility())
                .startedAt(career.getStartedAt())
                .endedAt(career.getEndedAt())
                .build();
    }
}
