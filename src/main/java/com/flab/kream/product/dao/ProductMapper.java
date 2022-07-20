package com.flab.kream.product.dao;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dto.ProductRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    void insertProduct( ProductRequestDTO productDTO );

    List<ProductRequestDTO> getProductList(Pagination pagination );

}
