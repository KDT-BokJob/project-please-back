package com.kdt.please.domain.interview;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.global.Status;
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
public class Interview {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "apply_id")
    private Apply apply;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;
}
