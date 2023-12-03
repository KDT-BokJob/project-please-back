package com.kdt.please.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kdt.please.domain.company.Company;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String name;

    @Column(length = 1000)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String name, String email, String profileImg, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImg;
        this.role = userRole;
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
