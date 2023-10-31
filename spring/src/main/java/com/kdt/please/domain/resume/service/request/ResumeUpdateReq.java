package com.kdt.please.domain.resume.service.request;

import javax.validation.constraints.NotNull;

public record ResumeUpdateReq(
        @NotNull
        String nationality,
        @NotNull
        String firstName,
        String middleName,
        @NotNull
        String lastName,
        @NotNull
        String koreanProficiency,
        String coverLetter,
        @NotNull
        String degree,
        @NotNull
        boolean isExperienced,
        @NotNull
        boolean isDisabled
) {
}
