package com.kdt.please.domain.user.service.request;

import java.time.LocalDate;

public record UserUpdateRequest(
        String name,
        String phone,
        LocalDate birthdate,
        String address,
        String gender,
        int period
) {
}
