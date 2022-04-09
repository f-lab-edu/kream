package com.flab.kream.product.service;

import com.flab.kream.product.dao.ProductDAO;
import com.flab.kream.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void registrationProduct(ProductDTO productDto) {
        productDAO.registrationProduct(productDto);
    }

}
