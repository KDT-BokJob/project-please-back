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
        Long applyId,
        Long userId,

        Long recruitId,

        Long resumeId,
        Status status
) {
    public static ApplyResponse from(Apply apply){
        return ApplyResponse.builder()
                .applyId(apply.getApplyId())
                .userId(apply.getUser().getUserId())
                .recruitId(apply.getRecruit().getRecruitId())
                .resumeId(apply.getResumeId())
                .status(apply.getStatus())
                .build();
    }

    public static List<ApplyResponse> from(List<Apply> applyList){
        return applyList.stream().map(ApplyResponse::from).collect(Collectors.toList());
    }
}
