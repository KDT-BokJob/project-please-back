package com.kdt.please.domain.feedback.repository;

import com.kdt.please.domain.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
