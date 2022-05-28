package com.flab.kream.order.service;

import com.flab.kream.order.mapper.OrderMapper;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderMapper orderDao;

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
    @DisplayName("주문 실패 테스트 - 멤버아이디 미입력")
    public void insertNotMemberIdFailTest() {
        //given
        orderRequest = orderRequest.builder().productId(1).quantity(1).createdBy("ADMIN").build();
        //when
        doThrow(IllegalArgumentException.class).when(orderDao).addOrder(any(OrderRequestDTO.class));
        //then
        assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orderRequest));
    }

    @Test
    @DisplayName("주문 실패 테스트 - 상품아이디 미입력")
    public void insertProductIdFailTest() {
        //given
        orderRequest = orderRequest.builder().memberId(1).createdBy("ADMIN").build();
        //when
        doThrow(IllegalArgumentException.class).when(orderDao).addOrder(any(OrderRequestDTO.class));
        //then
        assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orderRequest));
    }

    @Test
    @DisplayName("주문 실패 테스트 - 수량 미입력")
    public void insertNotQuantityFailTest() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(1).createdBy("ADMIN").build();
        //when
        doThrow(IllegalArgumentException.class).when(orderDao).addOrder(any(OrderRequestDTO.class));
        //then
        assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orderRequest));
    }
    
    @Test
    @DisplayName("주문 실패 테스트 - 등록자 미입력")
    public void insertNotCreatedByFailTest() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(1).build();
        //when
        doThrow(IllegalArgumentException.class).when(orderDao).addOrder(any(OrderRequestDTO.class));
        //then
        assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orderRequest));
    }

    @Test
    @DisplayName("createdBy 유효성 검사")
    public void createdByValid() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(1).createdBy(null).build();
        //when
        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);
        //then
        assertEquals(violations.size(), 1);
    }

    @Test
    @DisplayName("memberId 유효성 검사")
    public void memberIdValid() {
        //given
        orderRequest = orderRequest.builder().memberId(-1).productId(1).quantity(1).createdBy("ADMIN").build();
        //when
        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);
        //then
        assertEquals(violations.size(), 1);
    }

    @Test
    @DisplayName("productId 유효성 검사")
    public void productIdValid() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(-1).quantity(1).createdBy("ADMIN").build();
        //when
        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);
        //then
        assertEquals(violations.size(), 1);
    }

    @Test
    @DisplayName("quantity 유효성 검사")
    public void quantityValid() {
        //given
        orderRequest = orderRequest.builder().memberId(1).productId(1).quantity(-1).createdBy("ADMIN").build();
        //when
        Set<ConstraintViolation<OrderRequestDTO>> violations = validator.validate(orderRequest);
        //then
        assertEquals(violations.size(), 1);
    }
}