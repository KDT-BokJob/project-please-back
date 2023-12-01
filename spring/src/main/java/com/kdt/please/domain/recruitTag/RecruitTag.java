package com.kdt.please.domain.recruitTag;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RecruitTag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<RecruitTagMap> postTags = new HashSet<>();
}