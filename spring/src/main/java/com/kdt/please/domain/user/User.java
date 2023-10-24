package com.kdt.please.domain.user;

import com.kdt.please.domain.company.Company;
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
public class User {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String email;

    private String name;

    private String profileImg;

    private String phone;

    private LocalDate birth;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String gender;

    private String stayDuration;

}
