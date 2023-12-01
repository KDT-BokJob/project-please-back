package com.kdt.please.domain.apply.service.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record SelectEmployeeRequest(
        @NotNull @Positive
        long employeeId
) {
}
