package com.flab.kream.product.dao;

import com.flab.kream.product.dto.ProductRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void insertProduct( ProductRequestDTO productDTO );

}
