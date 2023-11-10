package com.kdt.please.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {
    // httpstatus는 code 대신 HttpsStatus 열거형 쓰는게 더 표준적

    SUCCESS(true, HttpStatus.OK, "요청에 성공하였습니다."),
    RESPONSE_ERROR(false, HttpStatus.NOT_FOUND, "값을 불러오는데 실패하였습니다."),
    DATA_NOT_FOUND(false,HttpStatus.INTERNAL_SERVER_ERROR,"존재하지 않는 정보입니다."),
    NULLPOINTER_EXCEPTION(false,HttpStatus.INTERNAL_SERVER_ERROR,"왜 기계에게 도전하려는가 휴~먼"),
    SESSION_INCONSISTENCY(false, HttpStatus.BAD_REQUEST, "다른 사람 정보를 궁금해 하지마"),
    INSERT_EXCEPTION(false,HttpStatus.INTERNAL_SERVER_ERROR,"감히 기계를 가르치려하다니 무례하다 휴~먼"),
    DATE_FORMAT_EXCEPTION(false,HttpStatus.BAD_REQUEST,"잘못된 날짜 정보입니다."),
    DATABASE_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR, "서버와의 연결에 실패하였습니다."),
    MODIFY_FAIL_USER(false, HttpStatus.INTERNAL_SERVER_ERROR, "유저 정보 수정 실패"),
    MODIFY_FAIL_USERVISA(false, HttpStatus.INTERNAL_SERVER_ERROR, "유저 비자 정보 수정 실패"),
    DELETE_FAIL_USER(false, HttpStatus.INTERNAL_SERVER_ERROR, "유저 정보 삭제 실패");

    private final boolean isSuccess;
    private final HttpStatus code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, HttpStatus code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
