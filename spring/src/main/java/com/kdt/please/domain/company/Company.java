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
    private Long id;

    private String businessId;

    private String name;

    private Integer manCount;

    private Integer foreignCount;
}
