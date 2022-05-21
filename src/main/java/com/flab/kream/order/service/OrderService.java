package com.flab.kream.order.service;

import com.flab.kream.order.mapper.OrderMapper;
import com.flab.kream.order.dto.OrderRequestDTO;
import com.flab.kream.order.dto.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderDao;

    @Transactional
    public void addOrder(OrderRequestDTO orderRequest) {
        orderDao.addOrder(orderRequest);
    }

    @Transactional(readOnly = true)
    public OrderResponseDTO selectOrder(OrderRequestDTO orderRequest) {
        return orderDao.selectOrder(orderRequest);
    }
}
