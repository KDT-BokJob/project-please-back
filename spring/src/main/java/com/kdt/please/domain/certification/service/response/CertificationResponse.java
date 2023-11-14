package com.kdt.please.domain.certification.service.response;

import com.kdt.please.domain.certification.Certification;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
public record CertificationResponse(

        @NotNull
        Long certificationId,

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
    public static CertificationResponse from(Certification certification){
        return CertificationResponse.builder()
                .certificationId(certification.getCertificationId())
                .certificationName(certification.getCertificationName())
                .issuedBy(certification.getIssuedBy())
                .issuedDate(certification.getIssuedDate())
                .expiredDate(certification.getExpiredDate())
                .build();
    }
}
