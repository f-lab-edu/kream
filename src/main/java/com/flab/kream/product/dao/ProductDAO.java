package com.flab.kream.product.dao;

import com.flab.kream.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDAO {

    void registrationProduct( ProductDTO productDTO );

}
