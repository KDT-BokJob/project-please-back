package com.kdt.please.domain.apply.service.response;

import com.kdt.please.domain.recruit.Recruit;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Builder
public record RecruitApplyListResponse(
        @NotNull @Positive
        Long applyId,

        @NotNull @Positive
        Long recruitId,

        @NotNull
        String title,

        @NotNull
        String workType,

        @NotNull
        String workLocation,

        @NotNull
        LocalDate expiredAt
) {
    public static RecruitApplyListResponse from(Recruit recruit, Long applyId){
        return RecruitApplyListResponse.builder()
                .applyId(applyId)
                .recruitId(recruit.getRecruitId())
                .title(recruit.getTitle())
                .workType(recruit.getWorkType())
                .workLocation(recruit.getWorkLocation())
                .expiredAt(recruit.getExpiredAt())
                .build();
    }
}
