package com.kdt.please.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaFilterId implements Serializable {

    private Integer jobCode;
    private String visa;
}
