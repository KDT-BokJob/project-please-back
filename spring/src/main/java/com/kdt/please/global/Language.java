package com.kdt.please.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    JAPAN("ja"),
    ENGLISH("en"),
    NEPAL("ne"),
    VIETNAM("vi"),
    CHINA("zh");

    private final String code;
}
