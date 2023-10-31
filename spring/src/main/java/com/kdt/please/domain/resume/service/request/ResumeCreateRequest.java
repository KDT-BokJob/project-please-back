package com.kdt.please.domain.resume.service.request;

import com.kdt.please.domain.resume.Resume;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;

public record ResumeCreateRequest(
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
    public Resume toEntity(){
        return Resume.builder()
                .nationality(nationality)
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .koreanProficiency(koreanProficiency)
                .coverLetter(coverLetter)
                .degree(degree)
                .isExperienced(isExperienced)
                .isDisabled(isDisabled).build();

    }
}
