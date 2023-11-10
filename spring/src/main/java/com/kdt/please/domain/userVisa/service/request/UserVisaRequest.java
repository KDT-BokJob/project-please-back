package com.kdt.please.domain.userVisa.service.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserVisaRequest(
        @NotNull
        String visa,
        @NotNull
        LocalDate created_at
) {
}
