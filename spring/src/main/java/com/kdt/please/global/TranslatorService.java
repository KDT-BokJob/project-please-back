package com.kdt.please.global;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kdt.please.domain.languageMapping.LanguageMapping;
import com.kdt.please.domain.languageMapping.repository.LanguageMappingRepository;
import com.kdt.please.domain.languageMapping.service.LanguageMappingService;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.repository.RecruitRepository;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import com.kdt.please.global.config.Text;
import com.kdt.please.global.config.Translation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;


@Transactional
@Service
public class TranslatorService {

    @Value("${azure.translation.apiKey}")
    private String apiKey;

    @Value("${azure.translation.endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate;
    private final RecruitRepository recruitRepository;
    private final LanguageMappingRepository languageMappingRepository;

    public TranslatorService(RestTemplate restTemplate, RecruitRepository recruitRepository, LanguageMappingRepository languageMappingRepository) {
        this.restTemplate = restTemplate;
        this.recruitRepository = recruitRepository;
        this.languageMappingRepository = languageMappingRepository;
    }

    public void translateText(Long recruitId, String targetLanguage) {
        String uri = endpoint + "translate?api-version=3.0&from=ko&to=" + targetLanguage;
        System.out.println(uri);

        ObjectMapper objectMapper = new ObjectMapper();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);
        headers.set("Content-Type", "application/json");
        headers.set("Ocp-Apim-Subscription-Region" , "koreacentral");

        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));

        try {
            // recruit json화 후 Text 객체에 빌드
            String jsonUser = objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(recruit);
            // Json 앞에 "text": "{Recruit}" 형태로 만들기 위한 Text 객체 빌드
            Text text = Text.builder().text(jsonUser).build();

            // 오브젝트 매퍼로 Text 객체 Json화
            String jsonText = objectMapper.writeValueAsString(text);

            // 앞에 대문자 T로 변경 text->Text
            jsonText = jsonText.replace("text", "Text");
            jsonText = jsonText.replace("preferredNationality", "\\\"preferredNationality");

            System.out.println(jsonText);

            // 양 끝에 대괄호로 닫아주고 API 전송
            HttpEntity<String> requestEntity = new HttpEntity<>("[" + jsonText + "]", headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
            // 받은 결과물에서 대괄호 제거
            String result = responseEntity.getBody().substring(1, responseEntity.getBody().length()-1);

            System.out.println("-----------------");
            System.out.println(result);
            // translation 객체로 역직렬화
            Translation translation = objectMapper.readValue(result, Translation.class);

            Recruit newRecruit = objectMapper.readValue(translation.getTranslations().get(0).getText().getText(), Recruit.class);
            newRecruit.setRecruitId(null);
            newRecruit.setCompany(recruit.getCompany());
            recruitRepository.save(newRecruit);

            LanguageMapping languageMapping = LanguageMapping.builder()
                        .countryCode(targetLanguage)
                        .koreaId(String.valueOf(recruit.getRecruitId()))
                        .foreignId(String.valueOf(newRecruit.getRecruitId()))
                        .build();
            languageMappingRepository.save(languageMapping);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
