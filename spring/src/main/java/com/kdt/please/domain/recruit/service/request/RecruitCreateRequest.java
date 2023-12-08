package com.kdt.please.domain.recruit.service.request;

import com.kdt.please.domain.recruit.Recruit;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record RecruitCreateRequest(
        @NotNull
        Long companyId,
        @NotNull
        String jobName,
        @NotNull
        String title,
        @NotNull
        String content,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate expiredAt,
        @NotNull
        Integer salary,
        @NotNull
        String workType,
        @NotNull
        String workLocation,
        @NotNull
        int workStartHour,
        @NotNull
        int workEndHour,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate workStartDate,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate workEndDate,

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
                .title(title)
                .content(content)
                .expiredAt(expiredAt)
                .salary(salary)
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