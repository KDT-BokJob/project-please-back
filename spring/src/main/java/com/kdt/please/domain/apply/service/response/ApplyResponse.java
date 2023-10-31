package com.kdt.please.domain.apply.service.response;

import com.kdt.please.global.Status;
import lombok.Builder;

@Builder
public record ApplyResponse(
        long applyId,
        long userId,

        long recruitId,

        long resumeId,
        Status status
) {
}
