package com.kdt.please.domain.resume.service.response;

import lombok.Builder;

@Builder
public record ResumeResponse(
        Long resumeId,
        String nationality,
        String firstName,
        String middleName,
        String lastName,
        Integer koreanProficiency,
        String coverLetter,
        String degree,
        boolean isExperienced,
        boolean isDisabled
) {
}
