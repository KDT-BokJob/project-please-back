package com.kdt.please.domain.recruit.service.response;

import com.kdt.please.domain.recruit.Recruit;

import java.util.List;

public record RecruitApplyResponse(
        String title,
        String companyName,
        String jobName,
        Integer salary,
        String workLocation,
        List<String> visa,
        int applicantCount
) {
    public static RecruitApplyResponse from(Recruit recruit, List<String> visaList, int applicantCount){
        return new RecruitApplyResponse(recruit.getTitle(), recruit.getCompany().getName(),
                recruit.getJobCode().getJobName(), recruit.getSalary(), recruit.getWorkLocation(), visaList, applicantCount);
    }
}
