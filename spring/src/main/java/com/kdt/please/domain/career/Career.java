package com.kdt.please.domain.career;

import com.kdt.please.domain.career.service.request.CareerUpdateRequest;
import com.kdt.please.domain.resume.Resume;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public void change(CareerUpdateRequest req){
        this.companyName = req.companyName();
        this.responsibility = req.responsibility();
        this.startedAt = req.startedAt();
        this.endedAt = req.endedAt();
    }
}
