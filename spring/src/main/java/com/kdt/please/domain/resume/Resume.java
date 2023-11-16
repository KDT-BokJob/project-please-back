package com.kdt.please.domain.resume;

import com.kdt.please.domain.career.Career;
import com.kdt.please.domain.certification.Certification;
import com.kdt.please.domain.resume.service.request.ResumeUpdateRequest;
import com.kdt.please.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @OneToOne
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

    private String image;

    private Boolean isExperienced;

    private Boolean isDisabled;

    private String coverLetter;

    private String hexaco;

    private String hopeJob;

    private String tag;

    private String resumeFile;

    private Boolean isCompleted;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.REMOVE)
    private List<Career> careers;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.REMOVE)
    private List<Certification> certifications;

    public boolean isTagExist(){
        return tag != null;
    }

    public boolean isHopeJobExist(){
        return hopeJob != null;
    }

    public void change(ResumeUpdateRequest req){
        this.firstName = req.firstName();
        this.lastName = req.lastName();
        this.phone = req.phone();
        this.birthdate = req.birthdate();
        this.address = req.address();
        this.gender = req.gender();
        this.nationality = req.nationality();
        this.period = req.period();
        this.koreanProficiency = req.koreanProficiency();
        this.isExperienced = req.isExperienced();
        this.isDisabled = req.isDisabled();
        this.coverLetter = req.coverLetter();
        this.hexaco = req.hexaco();
    }

}