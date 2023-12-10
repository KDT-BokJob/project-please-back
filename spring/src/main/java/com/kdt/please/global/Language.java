package com.kdt.please.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    JAPAN("ja"),
    ENGLISH("en"),
    VIETNAM("vi"),
    CHINA("zh");
    //NEPAL("ne");

    private final String code;
}
