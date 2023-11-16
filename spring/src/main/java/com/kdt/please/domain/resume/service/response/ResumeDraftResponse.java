package com.kdt.please.domain.resume.service.response;

import com.kdt.please.domain.resume.Resume;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Builder
public record ResumeDraftResponse(
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
        List<String> tag,
        String resumeFile,
        String visa,
        Boolean isCompleted
) {
    public static ResumeDraftResponse from(Resume resume, List<String> tagList, List<String> hopeJobList, String visa){
        return ResumeDraftResponse.builder()
                .resumeId(resume.getResumeId())
                .firstName(Optional.ofNullable(resume.getFirstName()).orElse(null))
                .lastName(Optional.ofNullable(resume.getLastName()).orElse(null))
                .phone(Optional.ofNullable(resume.getPhone()).orElse(null))
                .birthdate(Optional.ofNullable(resume.getBirthdate()).orElse(null))
                .address(Optional.ofNullable(resume.getAddress()).orElse(null))
                .gender(Optional.ofNullable(resume.getGender()).orElse(null))
                .nationality(Optional.ofNullable(resume.getNationality()).orElse(null))
                .period(Optional.ofNullable(resume.getPeriod()).orElse(null))
                .koreanProficiency(Optional.ofNullable(resume.getKoreanProficiency()).orElse(null))
                .isExperienced(Optional.ofNullable(resume.getIsExperienced()).orElse(null))
                .isDisabled(Optional.ofNullable(resume.getIsDisabled()).orElse(null))
                .coverLetter(Optional.ofNullable(resume.getCoverLetter()).orElse(null))
                .hexaco(Optional.ofNullable(resume.getHexaco()).orElse(null))
                .resumeFile(Optional.ofNullable(resume.getResumeFile()).orElse(null))
                .image(Optional.ofNullable(resume.getImage()).orElse(null))
                .tag(tagList)
                .hopeJob(hopeJobList)
                .visa(visa)
                .isCompleted(Optional.ofNullable(resume.getIsCompleted()).orElse(null))
                .build();
    }
}