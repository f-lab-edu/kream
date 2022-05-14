package com.flab.kream.product.service;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dao.ProductMapper;
import com.flab.kream.product.dto.ProductRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Transactional(rollbackFor = Exception.class)
    public void registProduct(ProductRequestDTO requestDTO) {
        productMapper.insertProduct(requestDTO);
    }

    @Transactional(readOnly = true)
    public List<ProductRequestDTO> findProductList(Pagination pagination) {
        return productMapper.getProductList(pagination);
    }

}
