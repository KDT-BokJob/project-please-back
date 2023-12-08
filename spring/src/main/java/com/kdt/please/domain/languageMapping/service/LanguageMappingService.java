package com.kdt.please.domain.languageMapping.service;

import com.kdt.please.domain.languageMapping.repository.LanguageMappingRepository;
import com.kdt.please.domain.languageMapping.service.response.LanguageMappingResponse;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class LanguageMappingService {
    private final LanguageMappingRepository languageMappingRepository;

    // id로 매핑 정보 조회
    public LanguageMappingResponse getLanguageMappingById(Long languageMappingId){
        return LanguageMappingResponse.from(languageMappingRepository.findById(languageMappingId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND)));
    }

    // 입력 받은 값으로 매핑 추가
    public LanguageMappingResponse saveOrUpdate(){

        return null;
    }

    // id로 매핑 정보 삭제
    public void deleteLanguageMappingById(Long languageMappingId){
        languageMappingRepository.deleteById(languageMappingId);
    }

    // 한국어 id, entity, 언어 코드로 정보 삭제
    public void deleteLanguageMapping(String entity, String countryCode, String koreaId){
        languageMappingRepository.deleteByCountryCodeAndKoreaId(countryCode, koreaId);
    }
}