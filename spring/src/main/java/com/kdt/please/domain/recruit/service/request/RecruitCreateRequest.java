package com.kdt.please.domain.recruit.service.request;

import com.kdt.please.domain.recruit.Recruit;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecruitCreateRequest(
        // 기업 ID
        @NotNull
        Long companyId,
        // 직업코드
        @NotNull
        String job_code,
        // 제목
        @NotNull
        String title,
        // 내용
        @NotNull
        String content,
        // 작성일
        LocalDate createdAt,
        // 마감일
        @NotNull
        LocalDate expiredAt,
        // 급여
        @NotNull
        Integer salary,
        // 근무 형태
        @NotNull
        String workType,
        // 장소
        @NotNull
        String workLocation,
        // 근무 시작 시간
        @NotNull
        int workStartHour,
        // 근무 종료 시간
        @NotNull
        int workEndHour,
        // 근무 기간
        int workPeriod,
        // 주중 근무 일수
        @NotNull
        int workDaysWeek

) {
    public Recruit toEntity(){
        return Recruit.builder()
                .job_code(job_code)
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .expiredAt(expiredAt)
                .salary(salary)
                .workType(workType)
                .workLocation(workLocation)
                .workDaysWeek(workDaysWeek)
                .workPeriod(workPeriod)
                .workStartHour(workStartHour)
                .workEndHour(workEndHour)
                .build();
    }
}
