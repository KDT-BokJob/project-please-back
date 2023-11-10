package com.kdt.please.domain.recruit.service.response;

import com.kdt.please.domain.recruit.Recruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record RecruitSimpleResponse(
        String companyName,
        String jobCode,
        Integer salary,
        String workLocation

) {
    public static RecruitSimpleResponse from(Recruit recruit){
        return new RecruitSimpleResponse(recruit.getCompany().getName(),
                recruit.getJobCode(), recruit.getSalary(), recruit.getWorkLocation());
    }

    public static List<RecruitSimpleResponse> from(List<Recruit> recruitList){
        return recruitList.stream().map(RecruitSimpleResponse::from).collect(Collectors.toList());
    }

}