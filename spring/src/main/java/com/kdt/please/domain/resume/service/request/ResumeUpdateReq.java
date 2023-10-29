package com.kdt.please.domain.resume.service.request;

public record ResumeUpdateReq(
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
}
