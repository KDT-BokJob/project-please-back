package com.kdt.please.domain.visa.response;

import com.kdt.please.domain.visa.Visa;
import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public record VisaInfoResponse(
        @NotNull
        String visa,
        Integer validityPeriod
) {
        public static VisaInfoResponse toEntity(Visa visa){
                return VisaInfoResponse.builder()
                        .visa(visa.getVisa())
                        .validityPeriod(visa.getValidityPeriod())
                        .build();
        }
}
