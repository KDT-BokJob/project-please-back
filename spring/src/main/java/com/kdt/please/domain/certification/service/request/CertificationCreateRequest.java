package com.kdt.please.domain.certification.service.request;

import com.kdt.please.domain.certification.Certification;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record CertificationCreateRequest(
        @NotNull
        Long resumeId,

        @NotNull
        String certificationName,

        @NotNull
        String issuedBy,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate issuedDate,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate expiredDate
) {
    public Certification toEntity(){
        return Certification.builder()
                .certificationName(certificationName)
                .issuedBy(issuedBy)
                .issuedDate(issuedDate)
                .expiredDate(expiredDate)
                .build();
    }
}
