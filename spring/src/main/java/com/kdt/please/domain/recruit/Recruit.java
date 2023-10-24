package com.kdt.please.domain.recruit;

import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recruit extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String title;

    private String content;

    private LocalDate endTime;

    private Integer pay;

    private String workType;

    private String jobName;

    private String location;

    private String workingHours;

    private String visa;

    private String workingPeriod;

}
