package com.kdt.please.domain.user.service.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserUpdateRequest(
        @NotNull
        String name,
        @NotNull
        String phone,
        @NotNull
        LocalDate birthdate,
        @NotNull
        String address,
        @NotNull
        String gender,
        @NotNull
        int period
) {
}
