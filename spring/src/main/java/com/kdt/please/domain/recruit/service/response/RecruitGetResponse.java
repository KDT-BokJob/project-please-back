package com.kdt.please.domain.recruit.service.response;

import java.time.LocalDateTime;

public record RecruitGetResponse(
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
