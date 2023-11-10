package com.kdt.please.domain.visa;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Visa {
    @Id
    private String visa;
    private Integer validityPeriod;
}
