package com.kdt.please.domain.apply.service.request;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record ApplyCreateRequest(

        @NotNull @Positive
        long userId,
        @NotNull @Positive
        long recruitId,
        @NotNull @Positive
        long resumeId
) {
}
