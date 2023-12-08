package com.kdt.please.global.config;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Translation {
    List<TranslationBody> translations;
}
