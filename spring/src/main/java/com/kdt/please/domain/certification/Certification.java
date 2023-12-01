package com.kdt.please.domain.certification;

import com.kdt.please.domain.certification.service.request.CertificationUpdateRequest;
import com.kdt.please.domain.resume.Resume;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
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

    public void change(CertificationUpdateRequest req){
        this.certificationName = req.certificationName();
        this.expiredDate = req.expiredDate();
        this.issuedBy = req.issuedBy();
        this.issuedDate = req.issuedDate();
    }
}
