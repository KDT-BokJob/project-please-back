package com.kdt.please.exception;

public class CustomException extends RuntimeException {
    private BaseResponseStatus status;

    public CustomException(BaseResponseStatus status) {
        super(status.getMessage());
        this.printStackTrace();
        this.status = status;
    }

    public BaseResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(final BaseResponseStatus status) {
        this.status = status;
    }
}
