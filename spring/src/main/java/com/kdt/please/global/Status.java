package com.kdt.please.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    IN_PROGRESS("IN_PROGRESS"),
    PASS("PASS"),
    FAIL("FAIL");

    private final String role;
}
