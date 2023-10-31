package com.kdt.please.domain.career.service.request;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record CareerUpdateRequest(
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
