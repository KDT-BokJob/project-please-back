package com.kdt.please.domain.resume.service.request;

import io.swagger.annotations.ApiModel;
public record ResumeCreateRequest(
        Long userId,
        String email,
        String country,
        String lastName,
        String middleName,
        String firstName,
        String visa,
        String koreanProficiency,
        boolean disabled,
        String residence,
        String education,
        String major

) {
}
