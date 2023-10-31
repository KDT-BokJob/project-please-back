package com.kdt.please.domain.userVisa.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserVisaRequest(
        @NotNull
        String visa,
        @NotNull
        LocalDate created_at
) {
}
