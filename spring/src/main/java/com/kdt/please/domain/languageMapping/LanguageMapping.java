package com.kdt.please.domain.languageMapping;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LanguageMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageMappingId;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private Long koreaId;

    @Column(nullable = false)
    private Long foreignId;
}