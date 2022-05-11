package com.flab.kream.order.service;

import com.flab.kream.order.dao.OrderDao;
import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
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
    private OrderRequest orderRequest;

    private Validator validator = null;


    @BeforeEach
    void setUp() {
        orderRequest = orderRequest.builder()
                .memberId(1)
                .productId(1)
                .quantity(1)
                .createdBy("ADMIN")
                .build();

    }
    @BeforeEach
    public void setupValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("조회테스트")
    public void selectTest(){

        when(orderDao.selectOrder(any(OrderRequest.class))).thenReturn(any(OrderResponse.class));

        orderService.selectOrder(orderRequest);

        verify(orderDao).selectOrder(any(OrderRequest.class));

    }

    @Test
    @DisplayName("주문 추가 테스트")
    public void insertTest(){

        doNothing().when(orderDao).addOrder(any(OrderRequest.class));
        orderService.addOrder(orderRequest);

    }


    @Test
    @DisplayName("등록자 유효성 검사")
    public void memberIdValid(){
        orderRequest = orderRequest.builder()
                .memberId(1)
                .productId(1)
                .quantity(1)
                .createdBy(null)
                .build();

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);

        assertEquals(violations.size(),1);


    }


}
