package com.flab.kream.exception;

import lombok.Data;

@Data
public class CustomExceptionResponseDto {
    private int errorCode;
    private String errorMsg;
}
