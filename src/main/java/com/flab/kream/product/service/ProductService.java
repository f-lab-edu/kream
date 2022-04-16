package com.flab.kream.product.service;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dao.ProductDAO;
import com.flab.kream.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    @Transactional
    public void registrationProduct(ProductDTO productDto) {
        productDAO.registrationProduct(productDto);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findProductList(Pagination pagination) {
        return productDAO.getProductList(pagination);
    }

}
