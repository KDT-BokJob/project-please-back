package com.kdt.please.domain.filter;

import com.kdt.please.domain.visa.Visa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaFilterId implements Serializable {

    @OneToOne
    @JoinColumn(name = "job_code")
    private JobCode jobCode;

    @OneToOne
    @JoinColumn(name = "visa")
    private Visa visa;
}
