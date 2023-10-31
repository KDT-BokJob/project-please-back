package com.kdt.please.domain.apply.service.response;

import com.kdt.please.global.Status;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
public record ApplyResponse(
        long applyId,
        long userId,

        long recruitId,

        long resumeId,
        Status status
) {
}
