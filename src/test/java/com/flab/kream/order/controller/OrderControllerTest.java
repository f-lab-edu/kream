package com.flab.kream.order.controller;

import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;



    @Test
    @DisplayName("주문 등록 테스트")
    public void orderTest() throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMemberId(1);
        orderRequest.setCreatedBy("1");
        orderRequest.setProductId(1);
        orderRequest.setUpdatedBy("1");
        orderRequest.setQuantity(1);
        orderService.addOrder(orderRequest);

    this.mockMvc.perform(post("/order/addOrder"))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());
    }


}
