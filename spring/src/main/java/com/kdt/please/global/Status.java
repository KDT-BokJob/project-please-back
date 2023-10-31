package com.kdt.please.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    APPLIED("APPLIED"), // 지원
    RESUME_REJECTED(" RESUME_REJECTED"), // 이력서 탈락
    INTERVIEW_SELECTED("INTERVIEW_SELECTED"), // 면접자 선정
    FINAL_PASSED("FINAL_PASSED"), // 최종 합격
    FINAL_REJECTED("FINAL_REJECTED"); // 최종 탈락

    private final String status;
}
