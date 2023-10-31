package com.kdt.please.domain.recruit.service.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecruitUpdateRequest(
        // 기업 ID
        Long companyId,
        // 직업코드
        String job_code,
        // 제목
        String title,
        // 내용
        String content,
        // 작성일
        LocalDate createdAt,
        // 마감일
        LocalDate expiredAt,
        // 급여
        Integer salary,
        // 근무 형태
        String workType,
        // 장소
        String workLocation,
        // 근무 시작 시간
        int workStartHour,
        // 근무 종료 시간
        int workEndHour,
        // 근무 기간
        int workPeriod,
        // 주중 근무 일수
        int workDaysWeek

) {
}
