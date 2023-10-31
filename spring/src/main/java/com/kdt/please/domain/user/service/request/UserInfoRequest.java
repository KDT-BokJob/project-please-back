package com.kdt.please.domain.user.service.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserInfoRequest(

        String name,
        String phone,
        LocalDate birthdate,
        String address,
        String gender,
        int period
) {
}
