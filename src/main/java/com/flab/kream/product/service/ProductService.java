package com.flab.kream.product.service;

import com.flab.kream.product.dao.ProductDAO;
import com.flab.kream.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    public void registrationProduct(ProductDTO productDto) {
        productDAO.registrationProduct(productDto);
    }

}
