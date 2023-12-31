package com.kdt.please.domain.userVisa;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.visa.Visa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserVisa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    //  @MapsId //@MapsId 는 @id로 지정한 컬럼에 @OneToOne 이나 @ManyToOne 관계를 매핑시키는 역할
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "visa")
    private Visa visa;
    private LocalDate createdAt;
    private LocalDate expiredAt;
}