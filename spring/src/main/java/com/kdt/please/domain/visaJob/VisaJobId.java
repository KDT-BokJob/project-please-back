package com.kdt.please.domain.visaJob;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class VisaJobId implements Serializable {
    private String jobCode;
    private String visa;
}
