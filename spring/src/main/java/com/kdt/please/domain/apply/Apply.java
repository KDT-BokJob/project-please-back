package com.kdt.please.domain.apply;

import com.kdt.please.domain.recruit.Recruit;
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
public class Apply {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    private Long resumeId;

    private Status status;
}
