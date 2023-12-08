package com.kdt.please.domain.feedback.service.request;


import com.kdt.please.domain.feedback.Feedback;

public record FeedbackCreateRequest(
        Long userId,
        String url,
        String content
) {
    public Feedback toEntity(){
        return Feedback.builder()
                .url(url)
                .content(content)
                .build();
    }
}
