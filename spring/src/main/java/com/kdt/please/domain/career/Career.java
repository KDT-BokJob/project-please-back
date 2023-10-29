package com.kdt.please.domain.career;

import com.kdt.please.domain.resume.Resume;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Career {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
    private String job;
    private String responsibility;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private String workPerformance;
    private String detail;
}
