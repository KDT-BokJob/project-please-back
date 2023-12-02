package com.kdt.please.domain.resume.service.request;

import com.kdt.please.domain.resume.Resume;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record ResumeUpdateRequest(
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
        Boolean isExperienced,
        @NotNull
        Boolean isDisabled,
        @NotNull
        String coverLetter,
        String hexaco,
        List<String> hopeJobs,

        List<String> tags,
        @NotNull
        String visa
) {
    public Resume toEntity(){
        return Resume.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .birthdate(birthdate)
                .address(address)
                .gender(gender)
                .nationality(nationality)
                .period(period)
                .koreanProficiency(koreanProficiency)
                .isExperienced(isExperienced)
                .isDisabled(isDisabled)
                .coverLetter(coverLetter)
                .hexaco(hexaco).build();
    }
}