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

    @Builder
    public User(String name, String email, String profileImg, String phone, LocalDate birth, String address,
                UserRole userRole, String gender) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImg;
        this.phone = phone;
        this.birthdate = birth;
        this.role = userRole;
        this.address = address;
        this.gender = gender;
    }

    public User update(String name, String profileImg) {
        this.name = name;
        this.profileImage = profileImg;

        return this;
    }

    public String getRoleKey() {
        return this.role.getRole();
    }
}
