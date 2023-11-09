package com.kdt.please.domain.recruit;

import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.filter.JobCode;
import com.kdt.please.domain.user.User;
import com.kdt.please.global.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recruit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String jobCode;

    private String title;

    private String content;

    private LocalDate expiredAt;

    private Integer salary;

    private String workType;

    private String workLocation;

    private int workPeriod;

    private int workDaysWeek;

    private int workStartHour;

    private int workEndHour;

}
