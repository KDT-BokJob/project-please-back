package com.kdt.please.domain.career;

import com.kdt.please.domain.resume.Resume;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Career {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
    private String companyName;
    private String responsibility;
    private LocalDate startedAt;
    private LocalDate endedAt;
}
