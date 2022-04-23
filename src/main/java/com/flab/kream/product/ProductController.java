package com.flab.kream.product;

import com.flab.kream.product.dto.ProductDTO;
import com.flab.kream.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> registration(@Valid @RequestBody ProductDTO productDto) {

        productService.registProduct(productDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
