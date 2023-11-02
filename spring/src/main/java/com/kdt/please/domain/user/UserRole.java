package com.kdt.please.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER("ROLE_USER", "회원"),
    RECRUITER("ROLE_RECRUITER", "구인자");

    private final String role;
    private final String title;


}
