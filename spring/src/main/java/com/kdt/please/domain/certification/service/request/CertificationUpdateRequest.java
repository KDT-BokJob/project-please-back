package com.kdt.please.domain.certification.service.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record CertificationUpdateRequest(

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
}
