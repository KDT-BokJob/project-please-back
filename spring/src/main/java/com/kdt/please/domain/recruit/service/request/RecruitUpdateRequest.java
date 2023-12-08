package com.kdt.please.domain.recruit.service.request;

import com.kdt.please.domain.recruit.Recruit;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Builder
public record RecruitUpdateRequest(
        // 기업 ID
        @NotNull
        Long companyId,
        // 직업코드
        @NotNull
        String jobName,
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
        LocalDate workStartDate,
        LocalDate workEndDate,
        // 주중 근무 일수
        String salaryType,
        String gender,
        List<String> tags,
        List<String> workDays,
        int count,

        boolean isTimeFlexible,

        boolean isPeriodFlexible,
        String preferredNationality

) {
        public Recruit toEntity(){
                return Recruit.builder()
                        //  .jobCode(jobCode)
                        .title(title)
                        .content(content)
                        .expiredAt(expiredAt)
                        .salary(salary)
                        .salaryType(salaryType)
                        .workType(workType)
                        .workLocation(workLocation)
                        .workStartDate(workStartDate)
                        .workEndDate(workEndDate)
                        .workStartHour(workStartHour)
                        .workEndHour(workEndHour)
                        .gender(gender)
                        .count(count)
                        .isTimeFlexible(isTimeFlexible)
                        .isPeriodFlexible(isPeriodFlexible)
                        .preferredNationality(preferredNationality)
                        .build();
        }
}