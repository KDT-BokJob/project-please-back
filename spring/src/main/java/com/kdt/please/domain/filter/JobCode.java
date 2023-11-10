package com.kdt.please.domain.filter;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class JobCode {
    @Id
    private String jobCode;

    private String jobName;
}
