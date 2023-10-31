package com.kdt.please.domain.career.service.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kdt.please.domain.resume.Resume;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Builder
public record CareerCreateRequest(
        @NotNull @Positive
        long resumeId,
        @NotNull
        String job,
        @NotNull
        String role,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate hireDate,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endDate,
        String workPerformance,
        String detailInfo
) {
}
