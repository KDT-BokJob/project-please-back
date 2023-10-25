package com.kdt.please.domain.visaJob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VisaJob {

    @Id @GeneratedValue
    private VisaJobId visaJobId;
    private String jobName;

}
