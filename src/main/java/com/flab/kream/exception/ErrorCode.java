package com.flab.kream.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "요청값이 유효하지 않습니다"),
    DATA_ACCESS_EXCEPTION(500, "데이터 액세스 예외가 발생했습니다"),
    BUSINESS_EXCEPTION(400, "비즈니스 예외가 발생했습니다"),
    NICKNAME_DUPLICATED(409, "닉네임이 중복되었습니다"),
    EMAIL_DUPLICATED(409, "이메일이 중복되었습니다"),
    INVALID_EMAIL_TOKEN(400, "이메일 토큰이 유효하지 않습니다"),
    NOT_MATCHED_PASSWORD(400, "비밀번호가 일치하지 않습니다"),
    NOT_MATCHED_ID(403, "ID가 일치하지 않습니다"),
    PERMISSION_DENIED_EXCEPTION(403, "권한이 거부되었습니다"),
    INVALID_PASSWORD_EXCEPTION(400, "비밀번호 암호화에 실패했습니다"),
    NOT_FOUND_PRODUCT(400, "조회되는 상품 데이터가 없습니다"),
    INVALID_PAGE_NUMBER_EXCEPTION(400, "잘못된 페이지 수 입니다.");

    private int status;
    private String message;
}
