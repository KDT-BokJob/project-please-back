package com.kdt.please.domain.resume.service.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ResumeUpdateRequest(

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
}
