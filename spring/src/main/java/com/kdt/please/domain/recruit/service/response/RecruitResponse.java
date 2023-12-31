package com.kdt.please.domain.recruit.service.response;

import com.kdt.please.domain.company.service.response.CompanyResponse;
import com.kdt.please.domain.recruit.Recruit;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record RecruitResponse(
        // 공고 ID
        Long recruitId,
        // 기업 ID
        CompanyResponse companyResponse,
        // 직업코드
        String jobName,
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
        String salaryType,
        // 근무 형태
        String workType,
        // 장소
        String workLocation,
        // 근무 시작 시간
        int workStartHour,
        // 근무 종료 시간
        int workEndHour,
        // 근무 기간
        LocalDate workStartDate,
        LocalDate workEndDate,
        String gender,
        List<String> visa,
        List<String> tags,
        List<String> workDays,
        int count,

        String fileUrl,

        boolean isTimeFlexible,

        boolean isPeriodFlexible,
        String preferredNationality

) {
    public static RecruitResponse from(Recruit recruit, List<String> visaList, List<String> tagList, List<String> workDayList){
        return RecruitResponse.builder()
                .recruitId(recruit.getRecruitId())
                .companyResponse(CompanyResponse.from(recruit.getCompany()))
                .jobName(recruit.getJobCode().getJobName())
                .title(recruit.getTitle())
                .content(recruit.getContent())
                .createdAt(recruit.getCreatedAt())
                .expiredAt(recruit.getExpiredAt())
                .salary(recruit.getSalary())
                .salaryType(recruit.getSalaryType())
                .workType(recruit.getWorkType())
                .workLocation(recruit.getWorkLocation())
                .workStartHour(recruit.getWorkStartHour())
                .workEndHour(recruit.getWorkEndHour())
                .workStartDate(recruit.getWorkStartDate())
                .workEndDate(recruit.getWorkEndDate())
                .gender(recruit.getGender())
                .visa(visaList)
                .tags(tagList)
                .workDays(workDayList)
                .count(recruit.getCount())
                .fileUrl(recruit.getFileUrl())
                .isTimeFlexible(recruit.getIsTimeFlexible())
                .isPeriodFlexible(recruit.getIsPeriodFlexible())
                .preferredNationality(recruit.getPreferredNationality())
                .build();

    }
}
