package com.flab.kream.order.controller;

import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import com.flab.kream.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.flab.kream.util.HttpResponses.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderResponse orderResponse;

    @PostMapping
    public ResponseEntity<OrderResponse>  addOrder(@Validated @RequestBody OrderRequest orderRequest){
        orderService.addOrder(orderRequest);
        return RESPONSE_CREATED;
    }

    @GetMapping("/selectOrder")
    public ResponseEntity<OrderResponse> selectOrder(@Validated @RequestBody OrderRequest orderRequest){
        OrderResponse response = orderService.selectOrder(orderRequest);

        if(response == null){
            return RESPONSE_BAD_REQUEST;
        }else{
            return RESPONSE_OK;
        }
    }

}
