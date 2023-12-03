package com.kdt.please.global;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.global.config.Text;
import com.kdt.please.global.config.Translation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TranslatorService {

    @Value("${azure.translation.apiKey}")
    private String apiKey;

    @Value("${azure.translation.endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate;

    public TranslatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String translateText(Object object, String targetLanguage) {
        String uri = endpoint + "translate?api-version=3.0&from=ko&to=" + targetLanguage;
        System.out.println(uri);

        ObjectMapper objectMapper = new ObjectMapper();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);
        headers.set("Content-Type", "application/json");
        headers.set("Ocp-Apim-Subscription-Region" , "koreacentral");

        User user = User.builder()
                .email("빌딩@d")
                .name("ge")
                .role(UserRole.USER)
                .build();

        try {
            // user json화 후 Text 객체에 빌드
            String jsonUser = objectMapper.writeValueAsString(user);
            // Json 앞에 "text": "{User}" 형태로 만들기 위한 Text 객체 빌드
            Text text = Text.builder().text(jsonUser).build();

            // 오브젝트 매퍼로 Text 객체 Json화
            String jsonText = objectMapper.writeValueAsString(text);

            // {"text":"{\"userId\":null,\"email\":\"빌딩@d\",\"name\":\"ge\",\"profileImage\":null,\"role\":\"USER\",\"roleKey\":\"ROLE_USER\"}"}
            System.out.println(jsonText);

            // 앞에 대문자 T로 변경 text->Text
            jsonText = jsonText.replace("text", "Text");

            // {"Text":"{\"userId\":null,\"email\":\"빌딩@d\",\"name\":\"ge\",\"profileImage\":null,\"role\":\"USER\",\"roleKey\":\"ROLE_USER\"}"}
            System.out.println(jsonText);

            // 양 끝에 대괄호로 닫아주고 API 전송
            HttpEntity<String> requestEntity = new HttpEntity<>("[" + jsonText + "]", headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
            // 받은 결과물에서 대괄호 제거
            String result = responseEntity.getBody().substring(1, responseEntity.getBody().length()-1);

            // {"translations":[{"text":"{\"userId\":null,\"email\":\"building@d\",\"name\":\"ge\",\"profileImage\":null,\"role\":\"USER\",\"roleKey\":\"ROLE_USER\"}","to":"ja"}]}
            System.out.println(result);
            
            // translation 객체로 역직렬화
            Translation translation = objectMapper.readValue(result, Translation.class);

            // 역직렬화한 객체안의 Text를 User로 역직렬화
            user = objectMapper.readValue(translation.getTranslations().get(0).getText().getText(), User.class);

            return user.toString();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
