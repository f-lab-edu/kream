package com.flab.kream.product;

import com.flab.kream.product.dto.ProductRequestDTO;
import com.flab.kream.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<HttpStatus> registration(@Valid @RequestBody ProductRequestDTO requestDTO) {
        productService.registProduct(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
