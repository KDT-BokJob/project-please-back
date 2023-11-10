package com.kdt.please.domain.user.service.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
public record UserInfoRequest(
        @NotNull
        String name,

        @NotNull
        String email,

        String profileImage
) {
}
