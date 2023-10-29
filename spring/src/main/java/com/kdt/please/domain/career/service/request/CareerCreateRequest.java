package com.kdt.please.domain.career.service.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kdt.please.domain.resume.Resume;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@ApiModel(value = "경력 등록")
public record CareerCreateRequest(

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
