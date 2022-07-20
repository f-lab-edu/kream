package com.flab.kream.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.flab.kream.common.model.Pagination;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    private ProductRequestDTO createProduct(int productId) {
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(productId);
        BigDecimal price = new BigDecimal(1000000);
        productDTO.setPrice(price);
        productDTO.setBrandId(1);
        productDTO.setImageUrl("test");

        return productDTO;
    }

    @Test
    @DisplayName("상품등록테스트 - 성공")
    void registProductTest() {
        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(000);
        BigDecimal price = new BigDecimal(2000000);
        productDTO.setPrice(price);
        productDTO.setBrandId(000);
        productDTO.setImageUrl("test");

        //when
        productService.registProduct(productDTO);

        //then
        verify(productMapper).insertProduct(any(ProductRequestDTO.class));
    }

    @Test
    @DisplayName("상품등록 - 브랜드ID @NotBlank 에러테스트")
    void validBrandIdTest() {
        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(000);
        productDTO.setName("nike killer whale");
        BigDecimal price = new BigDecimal(2000000);
        productDTO.setPrice(price);
        productDTO.setImageUrl("test");

        //when
        Set<ConstraintViolation<ProductRequestDTO>> validate = validator.validate(productDTO);

        //then
        validate.forEach(error -> {
            assertThat(error.getMessage()).isEqualTo("상품의 브랜드를 선택해주세요");
        });
    }

    @Test
    @DisplayName("상품등록 - 상품이름 @NotBlank 에러테스트")
    void validNameTest() {
        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(000);
        productDTO.setBrandId(001);
        BigDecimal price = new BigDecimal(2000000);
        productDTO.setPrice(price);
        productDTO.setImageUrl("test");

        //when
        Set<ConstraintViolation<ProductRequestDTO>> validate = validator.validate(productDTO);

        //then
        validate.forEach(error -> {
            assertThat(error.getMessage()).isEqualTo("상품명을 입력해주세요");
        });
    }

    @Test
    @DisplayName("상품등록 - 이미지url @NotBlank 에러테스트")
    void validImageUrlTest() {
        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(000);
        productDTO.setBrandId(000);
        productDTO.setName("nike killer whale");
        BigDecimal price = new BigDecimal(2000000);
        productDTO.setPrice(price);
        productDTO.setImageUrl(null);

        //when
        Set<ConstraintViolation<ProductRequestDTO>> validate = validator.validate(productDTO);

        //then
        validate.forEach(error -> {
            assertThat(error.getMessage()).isEqualTo("이미지를 업로드해주세요");
        });
    }

    @Test
    @DisplayName("상품등록 - 상품가격 @Min 에러테스트")
    void validPriceTest() {
        //given
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(0);
        productDTO.setBrandId(0);
        productDTO.setName("nike killer whale");
        BigDecimal price = new BigDecimal(-1);
        productDTO.setPrice(price);
        productDTO.setImageUrl("test");

        //when
        Set<ConstraintViolation<ProductRequestDTO>> validate = validator.validate(productDTO);

        //then
        validate.forEach(error -> {
            assertThat(error.getMessage()).isEqualTo("정확한 가격을 입력해주세요");
        });
    }

    @Test
    @DisplayName("상품 전체조회 테스트 - 성공")
    void findProductListTest() {
        //given
        List<ProductRequestDTO> productList = new ArrayList<>();
        productList.add(createProduct(1));
        productList.add(createProduct(2));

        Pagination pagination = new Pagination(1,10);

        when(productMapper.getProductList(any(Pagination.class))).thenReturn(productList);

        //when
        List<ProductRequestDTO> resultProductList = productService.findProductList(pagination);

        //then
        assertEquals(productList, resultProductList);
    }

}
