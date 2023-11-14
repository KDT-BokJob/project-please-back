package com.kdt.please.domain.apply.service.response;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.service.response.RecruitSimpleResponse;
import com.kdt.please.global.Status;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record ApplyResponse(
        long applyId,
        long userId,

        long recruitId,

        long resumeId,
        Status status
) {
    public static ApplyResponse from(Apply apply){
        return new ApplyResponse(apply.getApplyId(), apply.getUser().getUserId(),
                apply.getRecruit().getRecruitId(), apply.getResumeId(), apply.getStatus());
    }

    public static List<ApplyResponse> from(List<Apply> applyList){
        return applyList.stream().map(ApplyResponse::from).collect(Collectors.toList());
    }
}
