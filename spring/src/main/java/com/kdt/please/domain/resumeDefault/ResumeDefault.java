package com.kdt.please.domain.resumeDefault;

import com.kdt.please.domain.user.User;
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
public class ResumeDefault {

    @Id
    @GeneratedValue
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate birthdate;

    private String address;

    private String gender;

    private String nationality;

    private String period;

    private String koreanProficiency;

    private String degree;

    private boolean isExperienced;

    private boolean isDisabled;

    private String coverLetter;

    private String hexaco;

}
