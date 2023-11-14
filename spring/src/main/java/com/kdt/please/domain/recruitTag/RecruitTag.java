package com.kdt.please.domain.recruitTag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RecruitTag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String name;
}