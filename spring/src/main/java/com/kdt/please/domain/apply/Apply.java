package com.kdt.please.domain.apply;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.BaseEntity;
import com.kdt.please.global.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Apply extends BaseEntity {

    @Id @GeneratedValue
    private Long applyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    private Long resumeId;

    @Enumerated(EnumType.STRING)
    private Status status;
}
