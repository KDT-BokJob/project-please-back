package com.kdt.please.domain.recruit.service.request;

import com.kdt.please.domain.filter.JobCode;
import com.kdt.please.domain.recruit.Recruit;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecruitCreateRequest(
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
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
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
        @NotNull
        int workEndHour,
        LocalDate workStartDate,
        LocalDate workEndDate,
        int workDaysWeek,

        String gender

) {
    public Recruit toEntity(){
        return Recruit.builder()
                .title(title)
                .content(content)
                .expiredAt(expiredAt)
                .salary(salary)
                .workType(workType)
                .workLocation(workLocation)
                .workDaysWeek(workDaysWeek)
                .workStartDate(workStartDate)
                .workEndDate(workEndDate)
                .workStartHour(workStartHour)
                .workEndHour(workEndHour)
                .gender(gender)
                .build();
    }
}