package com.kdt.please.domain.reviewDetail;

import com.kdt.please.domain.review.Review;
import com.kdt.please.global.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetail {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review reviewId;

    private String title;

    private String content;

    private Integer grade;

}
