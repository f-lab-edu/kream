package com.flab.kream.service;

import com.flab.kream.common.model.Pagination;
import com.flab.kream.product.dao.ProductDAO;
import com.flab.kream.product.dto.ProductDTO;
import com.flab.kream.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Spy
    private ProductDAO productDAO;


    public ProductDTO createProduct(int productId) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setPrice("1000000");
        productDTO.setBrandId(1);
        productDTO.setImageUrl("test");

        return productDTO;
    }

    @Test
    void registrationProductTest() {

        //given
        ProductDTO productDTO = createProduct(1);

        //when
        productService.registrationProduct(productDTO);

        //then
        verify(productDAO).registrationProduct(any(ProductDTO.class));

    }

    @Test
    void findProductListTest() {
        //given
        List<ProductDTO> productList = new ArrayList<>();
        productList.add(createProduct(1));
        productList.add(createProduct(2));

        Pagination pagination = new Pagination(1,10);

        when(productDAO.getProductList(any(Pagination.class))).thenReturn(productList);

        //when
        List<ProductDTO> resultProductList = productService.findProductList(pagination);

        //then
        assertEquals(productList, resultProductList);
    }

}
