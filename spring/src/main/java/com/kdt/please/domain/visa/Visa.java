package com.kdt.please.domain.visa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Visa {
    @Id
    private String visa;
    private Integer period;
}
