package com.kdt.please.domain.career.service.request;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CareerUpdateRequest(
        @ApiModelProperty(value = "직무")
        String job,
        String role,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate hireDate,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endDate,
        String workPerformance,
        String detailInfo
) {

}
