package com.kdt.please.domain.career.service.request;

import com.kdt.please.domain.career.Career;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
public record CareerCreateRequest(
        @NotNull
        Long resumeId,
        @NotNull
        String companyName,
        @NotNull
        String responsibility,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate startedAt,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endedAt
) {
        public Career toEntity(){
                return Career.builder()
                        .companyName(companyName)
                        .responsibility(responsibility)
                        .startedAt(startedAt)
                        .endedAt(endedAt)
                        .build();
        }
}
