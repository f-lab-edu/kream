package com.flab.kream.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponses {

    public final ResponseEntity RESPONSE_OK = new ResponseEntity(HttpStatus.OK);
    public final ResponseEntity RESPONSE_CREATED = new ResponseEntity(HttpStatus.CREATED);
    public final ResponseEntity RESPONSE_BAD_REQUEST = new ResponseEntity(HttpStatus.BAD_REQUEST);
}
