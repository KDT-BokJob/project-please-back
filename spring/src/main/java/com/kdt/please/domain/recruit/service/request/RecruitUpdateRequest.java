package com.kdt.please.domain.recruit.service.request;

import java.time.LocalDateTime;

public record RecruitUpdateRequest(
        // 공고 ID
        Long postId,
        // 구인자 ID
        //Long recruiterId,
        // 기업 ID
        //Long companyId,
        // 제목
        String title,
        // 내용
        String content,
        // 작성일
        //LocalDateTime createAt,
        // 마감일
        LocalDateTime endTime,
        // 급여
        Integer pay,
        // 근무 형태
        String workType,
        // 장소
        String location,
        // 근무 시간
        String workingHours,
        // 근무 기간
        String workingPeriod,
        // 비자
        String visa,
        // 업종
        String jobName

) {
}
