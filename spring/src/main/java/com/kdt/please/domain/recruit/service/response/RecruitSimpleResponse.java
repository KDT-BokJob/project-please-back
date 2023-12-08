package com.kdt.please.domain.recruit.service.response;

import com.kdt.please.domain.recruit.Recruit;

import java.util.List;

public record RecruitSimpleResponse(
        Long recruitId,
        String title,
        String companyName,
        String jobName,
        Integer salary,
        String workLocation,
        List<String> visa

) {
    public static RecruitSimpleResponse from(Recruit recruit, List<String> visaList){
        return new RecruitSimpleResponse(recruit.getRecruitId(), recruit.getTitle(), recruit.getCompany().getName(),
                recruit.getJobCode().getJobName(), recruit.getSalary(), recruit.getWorkLocation(), visaList);
    }


}