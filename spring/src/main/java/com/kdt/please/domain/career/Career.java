package com.kdt.please.domain.career;

import com.kdt.please.domain.resumeDefault.ResumeDefault;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Career {
    @Id @GeneratedValue
    private Long careerId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private ResumeDefault resume;
    private String job;
    private String responsibility;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private String workPerformance;
    private String detail;
}