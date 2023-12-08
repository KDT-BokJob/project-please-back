package com.kdt.please.domain.feedback.service;

import com.kdt.please.domain.feedback.Feedback;
import com.kdt.please.domain.feedback.repository.FeedbackRepository;
import com.kdt.please.domain.feedback.service.request.FeedbackCreateRequest;
import com.kdt.please.domain.feedback.service.response.FeedbackResponse;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public Long createFeedback(FeedbackCreateRequest feedbackCreateRequest){
        Feedback feedback = feedbackCreateRequest.toEntity();
        User user = userRepository.findById(feedbackCreateRequest.userId())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        feedback.setUser(user);
        return feedbackRepository.save(feedback).getId();
    }

    public FeedbackResponse getFeedbackInfo(Long feedbackId){
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        return FeedbackResponse.from(feedback, feedback.getUser());
    }

    public List<FeedbackResponse> getFeedbackList(){
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return feedbackList.stream().map(feedback -> FeedbackResponse.from(feedback, feedback.getUser()))
                .collect(Collectors.toList());
    }
}
