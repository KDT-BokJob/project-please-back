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
    public static UserInfoResponse toEntity(User user){
        return UserInfoResponse.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .profileImage(user.getProfileImage())
                .role(user.getRole())
                .build();
    }

    public static UserInfoResponse from(User user){
        return new UserInfoResponse(user.getUserId(), user.getEmail(), user.getName(), user.getProfileImage(), user.getRole());
    }
}
