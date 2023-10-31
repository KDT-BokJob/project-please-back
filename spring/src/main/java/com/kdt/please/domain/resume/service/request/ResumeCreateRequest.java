package com.kdt.please.domain.resume.service.request;

import com.kdt.please.domain.resume.Resume;
import io.swagger.annotations.ApiModel;
public record ResumeCreateRequest(
        String nationality,
        String firstName,
        String middleName,
        String lastName,
        String koreanProficiency,
        String coverLetter,
        String degree,
        boolean isExperienced,
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
