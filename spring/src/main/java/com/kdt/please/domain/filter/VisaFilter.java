package com.kdt.please.domain.filter;

import com.kdt.please.domain.visa.Visa;
import lombok.Getter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Getter
@Entity
public class VisaFilter {
    @EmbeddedId
    private VisaFilterId id;
}
