package com.kdt.please.domain.recruitTag;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference(value = "tag")
    private Set<RecruitTagMap> postTags = new HashSet<>();
}