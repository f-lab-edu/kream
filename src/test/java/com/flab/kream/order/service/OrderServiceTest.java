package com.flab.kream.order.service;

import com.flab.kream.order.dao.OrderDao;
import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;


    @Test
    @DisplayName("주문 조회 테스트")
    public void orderTest(){
        //given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMemberId(1);

        //when
        OrderResponse findOrder = orderService.selectOrder(orderRequest);

        //then
        assertEquals(orderRequest.getMemberId(), findOrder.getMemberId());
    }

}
