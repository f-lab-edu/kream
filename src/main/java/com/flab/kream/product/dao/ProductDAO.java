package com.flab.kream.product.dao;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDAO {

    void registrationProduct( ProductDTO productDTO );

    List<ProductDTO> getProductList( Pagination pagination );

}
