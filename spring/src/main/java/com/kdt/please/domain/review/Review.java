package com.kdt.please.domain.review;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.BaseEntity;
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
public class Review extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

 //   private String reviewType;
    @Enumerated(EnumType.STRING)
    private ReviewState state;

}
