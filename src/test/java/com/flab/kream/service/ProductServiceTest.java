package com.flab.kream.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.flab.kream.product.dao.ProductMapper;
import com.flab.kream.product.dto.ProductRequestDTO;
import com.flab.kream.product.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @InjectMocks
    private ProductService productService;

    @Spy
    private ProductMapper productMapper;

    @BeforeAll
    public static void init(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    @DisplayName("상품등록테스트 - 성공")
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
        Set<ConstraintViolation<ProductRequestDTO>> validate = validator.validate(productDTO);

        //then
        validate.forEach(error -> {
            assertThat(error.getMessage()).isEqualTo("정확한 가격을 입력해주세요");
        });

    }

}
