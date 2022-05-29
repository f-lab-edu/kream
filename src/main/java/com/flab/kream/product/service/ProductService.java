package com.flab.kream.product.service;

import com.flab.kream.product.dao.ProductMapper;
import com.flab.kream.product.dto.ProductRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void registProduct(ProductRequestDTO requestDTO) {
        productMapper.insertProduct(requestDTO);
    }

}
