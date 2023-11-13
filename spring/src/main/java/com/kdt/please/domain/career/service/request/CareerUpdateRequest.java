package com.kdt.please.domain.career.service.request;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public record CareerUpdateRequest(
        @NotNull
        String companyName,
        @NotNull
        String role,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate hireDate,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endDate,
        String detail
) {

}
