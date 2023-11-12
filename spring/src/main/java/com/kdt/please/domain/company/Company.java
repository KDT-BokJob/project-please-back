package com.kdt.please.domain.company;

import com.kdt.please.domain.company.service.request.CompanyUpdateRequest;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String businessCode;

    private String name;

    private int employeeCount;

    private int foreignEmployeeCount;

    private String phone;

    private String address;

    private boolean isVisaTransform;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Recruit> recruits;

    public void changeCompany(CompanyUpdateRequest req){
        this.businessCode = req.businessCode();
        this.name = req.name();
        this.employeeCount = req.employeeCount();
        this.foreignEmployeeCount = req.foreignEmployeeCount();
        this.phone = req.phone();
        this.address = req.address();
        this.isVisaTransform = req.isVisaTransform();
    }
}