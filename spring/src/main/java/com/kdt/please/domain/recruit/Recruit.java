package com.kdt.please.domain.recruit;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.filter.JobCode;
import com.kdt.please.global.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    private int workDaysWeek;

    private int workStartHour;

    private int workEndHour;

    private String gender;

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.REMOVE)
    private List<Apply> apply;

    public  void changeRecruit(Recruit recruit) {
        this.title = recruit.getTitle();
        this.content = recruit.getContent();
        this.expiredAt = recruit.getExpiredAt();
        this.salary = recruit.getSalary();
        this.workType = recruit.getWorkType();
        this.workLocation = recruit.getWorkLocation();
        this.workStartDate = recruit.getWorkStartDate();
        this.workEndDate = recruit.getWorkEndDate();
        this.workDaysWeek = recruit.getWorkDaysWeek();
        this.workStartHour = recruit.getWorkStartHour();
        this.gender = recruit.getGender();
        this.workEndHour = recruit.getWorkEndHour();
    }

}