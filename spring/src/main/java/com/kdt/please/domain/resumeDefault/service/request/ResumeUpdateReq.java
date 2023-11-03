package com.kdt.please.domain.resumeDefault.service.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ResumeUpdateReq(
        @NotNull
        String firstName,

        @NotNull
        String lastName,

        @NotNull
        String phone,

        @NotNull
        LocalDate birthdate,

        @NotNull
        String address,
        @NotNull
        String gender,

        @NotNull
        String nationality,

        @NotNull
        String period,

        @NotNull
        String koreanProficiency,

        @NotNull
        String degree,

        @NotNull
        boolean isExperienced,

        @NotNull
        boolean isDisabled,

        String coverLetter,

        @NotNull
        String hexaco
) {
}
