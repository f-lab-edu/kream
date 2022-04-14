package com.flab.kream.product.service;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void registrationProduct(ProductDTO productDto);

    List<ProductDTO> findProductList(Pagination pagination);

}
