package com.kdt.please.global.config;

import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TranslationBody {
    Text text;
    String to;
}
