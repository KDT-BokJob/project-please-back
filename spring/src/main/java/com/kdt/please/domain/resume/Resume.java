package com.kdt.please.domain.resume;

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
public class Resume {

    @Id
    @GeneratedValue
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String nationality;

    private String firstName;

    private String middleName;

    private String lastName;

    private String koreanProficiency;

    private String coverLetter;

    private String degree;

    private LocalDate birthdate;

    private boolean isExperienced;

    private boolean isDisabled;

}
