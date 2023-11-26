package com.kdt.please.domain.feedback;

import com.kdt.please.domain.user.User;
import com.kdt.please.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Feedback extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String url;

    private String content;

}
