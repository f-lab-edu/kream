package com.flab.kream.service;

import com.flab.kream.product.dao.ProductMapper;
import com.flab.kream.product.dto.ProductRequestDTO;
import com.flab.kream.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Spy
    private ProductMapper productMapper;

    @Test
    @DisplayName("상품등록테스트")
    void registProductTest() {

        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(000);
        productDTO.setPrice("2000000");
        productDTO.setBrandId(000);
        productDTO.setImageUrl("test");

        //when
        productService.registProduct(productDTO);

        //then
        verify(productMapper).insertProduct(any(ProductRequestDTO.class));

    }

    @Test
    @DisplayName("parameter유효성을 검증한다")
    void registProductParameterTest() {

        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(null);
        productDTO.setBrandId(null);
        productDTO.setImageUrl(null);

        //when


        //then

    }

}
