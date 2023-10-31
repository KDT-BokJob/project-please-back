package com.kdt.please.domain.apply.service.request;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public record ApplyCreateRequest(

        long userId,

        long recruitId,

        long resumeId,
        Status status
) {
}
