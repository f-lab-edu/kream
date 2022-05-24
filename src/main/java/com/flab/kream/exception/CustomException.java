package com.flab.kream.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
