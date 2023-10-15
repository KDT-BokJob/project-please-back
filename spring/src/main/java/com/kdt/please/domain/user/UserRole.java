package com.kdt.please.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ROLE_USER("ROLE_USER"),
    ROLE_RECRUITER("ROLE_RECRUITER");

    private final String role;


}
