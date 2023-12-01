package com.kdt.please.domain.resume.service.request;

import com.kdt.please.domain.resume.Resume;

import java.time.LocalDate;
import java.util.List;

public record ResumeDraftRequest(
        String firstName,

        String lastName,

        String phone,

        LocalDate birthdate,

        String address,

        String gender,

        String nationality,

        String period,

        String koreanProficiency,

        Boolean isExperienced,

        Boolean isDisabled,

        String coverLetter,

        String hexaco,

        List<String> hopeJobs,

        List<String> tags,

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
                .hexaco(hexaco)
                .build();
    }
}