package com.kdt.please.domain.languageMapping.service.response;

import com.kdt.please.domain.languageMapping.LanguageMapping;
import lombok.Builder;

@Builder
public record LanguageMappingResponse(
        Long languageMappingId,

        String countryCode,

        String koreaId,

        String foreignId
) {
    public static LanguageMappingResponse from(LanguageMapping languageMapping){
        return LanguageMappingResponse.builder().
                languageMappingId(languageMapping.getLanguageMappingId())
                .countryCode(languageMapping.getCountryCode())
                .koreaId(languageMapping.getKoreaId())
                .foreignId(languageMapping.getForeignId())
                .build();
    }
}