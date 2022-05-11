package com.flab.kream.order.service;

import com.flab.kream.order.dao.OrderDao;
import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    @Transactional
    public void addOrder(OrderRequest orderRequest) {
        orderDao.addOrder(orderRequest);
    }

    @Transactional(readOnly = true)
    public OrderResponse selectOrder(OrderRequest orderRequest){
        return orderDao.selectOrder(orderRequest);

    }


}
