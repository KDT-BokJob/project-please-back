package com.kdt.please.domain.apply.service.response;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.resume.Resume;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Builder
public record UserApplyListResponse(
        @NotNull @Positive
        Long applyId,

        @NotNull @Positive
        Long resumeId,

        @NotNull
        String firstName,

        @NotNull
        String lastName,

        @NotNull
        String gender,

        @NotNull
        String age,

        @NotNull
        Boolean isExperienced,

        @NotNull
        String address,

        @NotNull
        String nationality
) {
    public static UserApplyListResponse from(Resume resume, Long applyId){
        return UserApplyListResponse.builder()
                .applyId(applyId)
                .resumeId(resume.getResumeId())
                .firstName(resume.getFirstName())
                .lastName(resume.getLastName())
                .gender(resume.getGender())
                .age(String.valueOf(LocalDate.now().getYear() - resume.getBirthdate().getYear()))
                .isExperienced(resume.isExperienced())
                .address(resume.getAddress())
                .nationality(resume.getNationality())
                .build();
    }
}
