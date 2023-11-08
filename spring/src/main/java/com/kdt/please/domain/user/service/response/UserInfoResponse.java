package com.kdt.please.domain.user.service.response;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserInfoResponse(
        long id,
        String email,
        String name,
        String profileImage,
        UserRole role
) {
}
