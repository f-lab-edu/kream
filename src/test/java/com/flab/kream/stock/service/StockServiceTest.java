package com.flab.kream.stock.service;

import com.flab.kream.stock.dto.StockRequestDTO;
import com.flab.kream.stock.dto.StockResponseDTO;
import com.flab.kream.stock.mapper.StockMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @InjectMocks
    private StockService stockService;

    @Mock
    private StockMapper stockMapper;

    @Mock
    private StockRequestDTO stockRequestDTO;

    private Validator validator = null;

    @BeforeEach
    void setUp() {
        stockRequestDTO = stockRequestDTO.builder().productId(1).build();
    }

    @BeforeEach
    public void setupValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("사이즈 조회 성공 테스트")
    @SuppressWarnings("unchecked")
    public void selectProductSizeTest() {
        //given
        when(stockMapper.selectStock(any(StockRequestDTO.class))).thenReturn((List<StockResponseDTO>) any(StockRequestDTO.class));
        //when
        stockService.selectStock(stockRequestDTO);
        //then
        verify(stockMapper).selectStock(any(StockRequestDTO.class));
    }

    @Test
    @DisplayName("사이즈 조회 실패 테스트 - 상품아이디 오입력")
    public void selectProductSizeFailTest() {
        //given
        stockRequestDTO = stockRequestDTO.builder().productId(-1).build();
        //when
        Set<ConstraintViolation<StockRequestDTO>> violations = validator.validate(stockRequestDTO);
        //then
        assertEquals(violations.size(), 1);
    }
}
