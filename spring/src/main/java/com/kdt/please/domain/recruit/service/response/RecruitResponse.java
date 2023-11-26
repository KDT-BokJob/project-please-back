package com.kdt.please.domain.recruit.service.response;

import com.kdt.please.domain.company.service.response.CompanyResponse;
import com.kdt.please.domain.recruit.Recruit;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record RecruitResponse(
        // 공고 ID
        String recruitId,
        // 기업 ID
        CompanyResponse companyResponse,
        // 직업코드
        String jobName,
        // 제목
        String title,
        // 내용
        String content,
        // 작성일
        String createdAt,
        // 마감일
        String expiredAt,
        // 급여
        String salary,
        // 근무 형태
        String workType,
        // 장소
        String workLocation,
        // 근무 시작 시간
        String workStartHour,
        // 근무 종료 시간
        String workEndHour,
        // 근무 기간
        String workStartDate,
        String workEndDate,
        // 주중 근무 일수
        String workDaysWeek,
        String gender,
        List<String> visa,
        List<String> tags
) {
    public static RecruitResponse from(Recruit recruit, List<String> visaList, List<String> tagList){
        return RecruitResponse.builder()
                .recruitId(String.valueOf(recruit.getRecruitId()))
                .companyResponse(CompanyResponse.from(recruit.getCompany()))
                .jobName(recruit.getJobCode().getJobName())
                .title(recruit.getTitle())
                .content(recruit.getContent())
                .createdAt(String.valueOf(recruit.getCreatedAt()))
                .expiredAt(String.valueOf(recruit.getExpiredAt()))
                .salary(String.valueOf(recruit.getSalary()))
                .workType(recruit.getWorkType())
                .workLocation(recruit.getWorkLocation())
                .workStartHour(String.valueOf(recruit.getWorkStartHour()))
                .workEndHour(String.valueOf(recruit.getWorkEndHour()))
                .workStartDate(String.valueOf(recruit.getWorkStartDate()))
                .workEndDate(String.valueOf(recruit.getWorkEndDate()))
                .workDaysWeek(String.valueOf(recruit.getWorkDaysWeek()))
                .gender(recruit.getGender())
                .visa(visaList)
                .tags(tagList)
                .build();

    }
}
