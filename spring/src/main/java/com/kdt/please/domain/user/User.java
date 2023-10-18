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

    private String name;

    private String email;

    private String profileImg;

    private String phone;

    private LocalDate birth;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String gender;

    @Builder
    public User(String name, String email, String profileImg, String phone, LocalDate birth, String address,
                UserRole userRole, String gender) {
        this.name = name;
        this.email = email;
        this.profileImg = profileImg;
        this.phone = phone;
        this.birth = birth;
        this.userRole = userRole;
        this.address = address;
        this.gender = gender;
    }

    public User update(String name, String profileImg) {
        this.name = name;
        this.profileImg = profileImg;

        return this;
    }

    public String getRoleKey() {
        return this.userRole.getRole();
    }
}
