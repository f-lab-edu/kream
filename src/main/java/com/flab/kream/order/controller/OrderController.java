package com.flab.kream.order.controller;

import com.flab.kream.order.dto.OrderRequestDTO;
import com.flab.kream.order.dto.OrderResponseDTO;
import com.flab.kream.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> addOrder(@Validated @RequestBody OrderRequestDTO orderRequest) {
        orderService.addOrder(orderRequest);
        return new ResponseEntity<OrderResponseDTO>(HttpStatus.CREATED);
    }
}
