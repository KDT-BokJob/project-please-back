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

    private String email;

    private String name;

    private String profileImage;

    private String phone;

    private LocalDate birthdate;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String gender;

    private String period;

    private String hexaco;

}
