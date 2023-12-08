package com.kdt.please.domain.recruit;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.filter.JobCode;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import com.kdt.please.domain.recruitTag.RecruitTagMap;
import com.kdt.please.global.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "job_code")
    private JobCode jobCode;

    private String title;

    private String content;

    private LocalDate expiredAt;

    private String salaryType;

    private Integer salary;

    private String workType;

    private String workLocation;

    private LocalDate workStartDate;

    private LocalDate workEndDate;

    private int workStartHour;

    private int workEndHour;

    private String gender;

    private String workDays;

    private int count;

    private String fileUrl;

    private Boolean isTimeFlexible;

    private Boolean isPeriodFlexible;

    private String preferredNationality;

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.REMOVE)
    private List<Apply> apply;

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<RecruitTagMap> tags = new HashSet<>();

    public  void changeRecruit(RecruitUpdateRequest req) {
        this.title = req.title();
        this.content = req.content();
        this.expiredAt = req.expiredAt();
        this.salary = req.salary();
        this.salaryType = req.salaryType();
        this.workType = req.workType();
        this.workLocation = req.workLocation();
        this.workStartDate = req.workStartDate();
        this.workEndDate = req.workEndDate();
        this.workStartHour = req.workStartHour();
        this.gender = req.gender();
        this.workEndHour = req.workEndHour();
        this.count = req.count();
        this.isTimeFlexible = req.isTimeFlexible();
        this.isPeriodFlexible = req.isPeriodFlexible();
        this.preferredNationality = req.preferredNationality();
    }

}