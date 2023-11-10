package com.kdt.please.domain.visa.response;

import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public record VisaInfoResponse(
        @NotNull
        String visa,
        Integer validityPeriod
) {
}
