package com.kdt.please.domain.userVisa.service.response;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.userVisa.UserVisa;
import com.kdt.please.domain.visa.Visa;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
public record UserVisaInfoResponse(
        @NotNull
        Long id,
        @NotNull
        Visa visa,
        LocalDate createdAt,
        LocalDate expiredAt
) {
    public static UserVisaInfoResponse toEntity(UserVisa userVisa){
        return UserVisaInfoResponse.builder()
                .id(userVisa.getId())
                .visa(userVisa.getVisa())
                .createdAt(userVisa.getCreatedAt())
                .expiredAt(userVisa.getExpiredAt())
                .build();
    }
}
