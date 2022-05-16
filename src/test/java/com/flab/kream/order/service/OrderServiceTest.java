package com.flab.kream.order.service;

import com.flab.kream.order.dao.OrderDao;
import com.flab.kream.order.dto.OrderRequestDTO;
import com.flab.kream.order.dto.OrderResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @Mock
    private OrderRequestDTO orderRequest;

    private Validator validator = null;


    @BeforeEach
    void setUp() {
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(1).createdBy("ADMIN").build();

    }

    @BeforeEach
    public void setupValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("주문 조회테스트")
    public void selectTest() {

        when(orderDao.selectOrder(any(OrderRequestDTO.class))).thenReturn(any(OrderResponseDTO.class));

        orderService.selectOrder(orderRequest);

        verify(orderDao).selectOrder(any(OrderRequestDTO.class));

    }

    @Test
    @DisplayName("주문 추가 테스트")
    public void insertTest() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(1).createdBy("ADMIN").build();

        //when
        orderService.addOrder(orderRequest);

        //then
        verify(orderDao).addOrder(any(OrderRequestDTO.class));
    }


    @Test
    @DisplayName("createdBy 유효성 검사")
    public void createdByValid() {
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(1).createdBy(null).build();

        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);

        assertEquals(violations.size(), 1);


    }

    @Test
    @DisplayName("memberId 유효성 검사")
    public void memberIdValid() {
        orderRequest = orderRequest.builder().memberId(0).productId(1).quantity(1).createdBy("ADMIN").build();

        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);

        assertEquals(violations.size(), 1);
    }

    @Test
    @DisplayName("productId 유효성 검사")
    public void productIdValid() {
        orderRequest = orderRequest.builder().memberId(1).productId(0).quantity(1).createdBy("ADMIN").build();

        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);

        assertEquals(violations.size(), 1);
    }

    @Test
    @DisplayName("quantity 유효성 검사")
    public void quantityValid() {
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(0).createdBy("ADMIN").build();

        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);

        assertEquals(violations.size(), 1);
    }


}
