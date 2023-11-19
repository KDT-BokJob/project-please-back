package com.kdt.please.domain.resume.service.response;

import com.kdt.please.domain.resume.Resume;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Boolean isExperienced,
        Boolean isDisabled,
        String coverLetter,
        String hexaco,
        String image,
        List<String> hopeJob,
        List<String> tags,
        String resumeFile,
        String visa,
        Boolean isCompleted
) {
    public static ResumeResponse from(Resume resume, List<String> tagList, List<String> hopeJobList, String visa){
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
                .isExperienced(resume.getIsExperienced())
                .isDisabled(resume.getIsDisabled())
                .coverLetter(resume.getCoverLetter())
                .hexaco(resume.getHexaco())
                .resumeFile(resume.getResumeFile())
                .image(resume.getImage())
                .tags(tagList)
                .hopeJob(hopeJobList)
                .visa(visa)
                .isCompleted(resume.getIsCompleted())
                .build();
    }
}
