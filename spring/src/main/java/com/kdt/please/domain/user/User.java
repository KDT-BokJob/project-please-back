package com.kdt.please.domain.user;

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

    private String profileImg;

    private String phone;

    private LocalDate birth;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String gender;

}
