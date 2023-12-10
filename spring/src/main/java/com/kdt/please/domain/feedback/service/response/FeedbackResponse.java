package com.kdt.please.domain.feedback.service.response;

import com.kdt.please.domain.feedback.Feedback;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.service.response.UserInfoResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FeedbackResponse(
    UserInfoResponse userInfoResponse,
    String url,
    String content,
    LocalDateTime createdAt
) {
    public static FeedbackResponse from(Feedback feedback, User user){
        return new FeedbackResponse(UserInfoResponse.from(user), feedback.getUrl(), feedback.getContent(), feedback.getCreatedAt());
    }
}
