package com.kdt.please.domain.filter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobCode {
    @Id
    private Integer jobCode;

    private String jobName;
}
