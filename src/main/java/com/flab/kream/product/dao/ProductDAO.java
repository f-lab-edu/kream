package com.flab.kream.product.dao;

import com.flab.kream.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

    void registrationProduct( ProductDTO productDTO );

}
