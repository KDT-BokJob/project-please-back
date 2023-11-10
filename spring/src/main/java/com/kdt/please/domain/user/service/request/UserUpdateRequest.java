package com.kdt.please.domain.user.service.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserUpdateRequest(
        @NotNull
        String name,

        String profileImage
) {
}
