package com.kdt.please.global;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import lombok.AllArgsConstructor;
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
        String uri = endpoint + "translate?api-version=3.0&to=" + targetLanguage;
        System.out.println(uri);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);
        headers.set("Content-Type", "application/json");
        headers.set("Ocp-Apim-Subscription-Region" , "koreacentral");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(JsonWriteFeature.QUOTE_FIELD_NAMES.mappedFeature());
        User user = User.builder()
                .email("e@d")
                .name("ge")
                .role(UserRole.USER)
                .build();
        String string = user.toString();
        string.substring(5, string.length() - 2);
        string.replace("=", ":");
        string.replace(",", "");

        String text = "";
        try {
            String jsonString = objectMapper.writeValueAsString(user);

            System.out.println(jsonString);
            text = jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        text.replace("\"", "");
        string = "[{\"Text\": \"" + string + "\"}]";
        System.out.println(string); //"[{\"Text\": \"{userId:null}\"}]"
        HttpEntity<String> requestEntity = new HttpEntity<>("[{\"Text\": \"{userId:null}\"}]" , headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

        return responseEntity.getBody();
    }
}
