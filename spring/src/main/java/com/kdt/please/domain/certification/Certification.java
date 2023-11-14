package com.kdt.please.domain.certification;

import com.kdt.please.domain.resume.Resume;
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
public class Certification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    private String certificationName;

    private String issuedBy;

    private LocalDate issuedDate;

    private LocalDate expiredDate;
}
