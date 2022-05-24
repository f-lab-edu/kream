package com.flab.kream.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //비즈니스로직 error처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponseDto> customException(CustomException customException) {
        CustomExceptionResponseDto customExceptionResponseDto = new CustomExceptionResponseDto();
        customExceptionResponseDto.setErrorCode(customException.getErrorCode().getStatus());
        customExceptionResponseDto.setErrorMsg(customException.getErrorCode().getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customExceptionResponseDto);
    }

    //@Valid error처리
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> validException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
    }

}
