package com.flab.kream.product.service;

import com.flab.kream.product.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    public ResponseEntity<HttpStatus> registrationProduct(ProductDto productDto);

}
