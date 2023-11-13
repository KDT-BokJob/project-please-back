package com.kdt.please.domain.resume.service.request;

import com.kdt.please.domain.resume.Resume;
import com.kdt.please.domain.user.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ResumeCreateRequest(

        String firstName,

        String lastName,

        String phone,

        LocalDate birthdate,

        String address,

        String gender,

        String nationality,

        String period,

        String koreanProficiency,

        String degree,

        boolean isExperienced,

        boolean isDisabled,

        String coverLetter,

        String hexaco,

        String hopeJob,

        String tag,

        String resume_file,

        Boolean isCompleted

) {
    public Resume toEntity(User user){
        return Resume.builder()
                .user(user)
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
                .hexaco(hexaco)
                .hopeJob(hopeJob)
                .resume_file(resume_file)
                .isCompleted(isCompleted)
                .build();
    }
}
