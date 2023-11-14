package com.kdt.please.domain.resume.service.response;

import com.kdt.please.domain.resume.Resume;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ResumeResponse(
        Long resumeId,
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
    public static ResumeResponse from(Resume resume){
        return ResumeResponse.builder()
                .resumeId(resume.getResumeId())
                .firstName(resume.getFirstName())
                .lastName(resume.getLastName())
                .phone(resume.getPhone())
                .birthdate(resume.getBirthdate())
                .address(resume.getAddress())
                .gender(resume.getGender())
                .nationality(resume.getNationality())
                .period(resume.getPeriod())
                .koreanProficiency(resume.getKoreanProficiency())
                .degree(resume.getDegree())
                .isExperienced(resume.isExperienced())
                .isDisabled(resume.isDisabled())
                .coverLetter(resume.getCoverLetter())
                .hexaco(resume.getHexaco())
                .tag(resume.getTag())
                .resume_file(resume.getResume_file())
                .isCompleted(resume.getIsCompleted())
                .build();
    }
}
