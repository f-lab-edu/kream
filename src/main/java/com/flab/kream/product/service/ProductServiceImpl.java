package com.flab.kream.product.service;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dao.ProductDAO;
import com.flab.kream.product.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    @Override
    public void registrationProduct(ProductDTO productDto) {
        productDAO.registrationProduct(productDto);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> findProductList(Pagination pagination) {
        return productDAO.getProductList(pagination);
    }

}
