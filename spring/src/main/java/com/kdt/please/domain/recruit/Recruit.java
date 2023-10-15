package com.kdt.please.domain.recruit;

import com.kdt.please.domain.recruiter.Recruiter;
import com.kdt.please.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    private Recruiter recruiter;

    private String title;

    private String content;

    private LocalDate endTime;

    private Integer salary;

    private String workType;

    private String jobType;

    private String region;

    private String day;

    private String time;

    private Double latitude;

    private Double longitude;
}
