package com.kdt.please.domain.resume.service.response;

import io.swagger.annotations.ApiModelProperty;

public record ResumeGetResponse(
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
