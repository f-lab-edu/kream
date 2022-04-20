package com.flab.kream.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    //실제로 사용하지 않는 ExceptionHandler예시입니다 
    @ExceptionHandler(RuntimeException.class) // 처리할 예외의 종류를 설정한다.
    public ErrorCode handleDuplicateIdException(RuntimeException e) {
        //
        return ErrorCode.BUSINESS_EXCEPTION;
    }



}
