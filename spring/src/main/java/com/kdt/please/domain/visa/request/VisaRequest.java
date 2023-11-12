package com.kdt.please.domain.visa.request;

import javax.validation.constraints.NotNull;

public record VisaRequest(
        @NotNull
        String visa,

        @NotNull
        Integer validityPeriod
) {
}
