package com.kdt.please.domain.visa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visa {
    @Id
    private String visa;
    private Integer validityPeriod;
}
