package com.kdt.please.domain.resumeDefault.service.request;

import com.kdt.please.domain.resumeDefault.ResumeDefault;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ResumeCreateRequest(
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
    public ResumeDefault toEntity(){
        return ResumeDefault.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .birthdate(birthdate)
                .address(address)
                .gender(gender)
                .nationality(nationality)
                .period(period)
                .koreanProficiency(koreanProficiency)
                .degree(degree)
                .isExperienced(isExperienced)
                .isDisabled(isDisabled)
                .coverLetter(coverLetter)
                .hexaco(hexaco).build();

    }
}
