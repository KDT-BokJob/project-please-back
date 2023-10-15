package com.kdt.please.domain.recruiter;

import com.kdt.please.domain.user.User;
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
public class Recruiter {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String businessId;

    private String businessName;

    private Integer businessManCount;
}
