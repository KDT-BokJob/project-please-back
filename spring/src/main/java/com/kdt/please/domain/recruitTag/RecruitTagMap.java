package com.kdt.please.domain.recruitTag;

import com.kdt.please.domain.recruit.Recruit;
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
public class RecruitTagMap {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private RecruitTag tag;
}