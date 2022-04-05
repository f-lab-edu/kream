package com.flab.kream.product.service;

import com.flab.kream.product.dto.ProductDto;
import com.flab.kream.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ResponseEntity<HttpStatus> registrationProduct(ProductDto productDto) {
        return null;
    }

}
