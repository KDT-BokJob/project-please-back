package com.kdt.please.domain.recruit.service.request;

import java.time.LocalDateTime;

public record RecruitCreateRequest(
        Long recruiterId,
        Long companyId,
        String title,
        String content,
        LocalDateTime createAt,
        LocalDateTime endTime,
        Integer pay,
        String workType,
        String location,
        String workingHours,
        String workingPeriod,
        String visa,
        String jobName

) {
}
