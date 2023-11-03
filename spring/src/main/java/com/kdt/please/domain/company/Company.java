package com.kdt.please.domain.company;

import com.kdt.please.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id @GeneratedValue
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
}
