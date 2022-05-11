package com.flab.kream.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponses {

    public static final ResponseEntity RESPONSE_OK = new ResponseEntity(HttpStatus.OK);
    public static final ResponseEntity RESPONSE_CREATED = new ResponseEntity(HttpStatus.CREATED);
    public static final ResponseEntity RESPONSE_BAD_REQUEST = new ResponseEntity(HttpStatus.BAD_REQUEST);
}
