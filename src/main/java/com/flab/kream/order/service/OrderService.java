package com.flab.kream.order.service;

import com.flab.kream.order.dao.OrderDao;
import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderDao orderDao;

    @Transactional
    public OrderResponse addOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = this.selectOrder(orderRequest);
        if(orderResponse == null){
            return orderDao.addOrder(orderRequest);
        }else{
            throw new NullPointerException();
        }
    }

    @Transactional(readOnly = true)
    public OrderResponse selectOrder(OrderRequest orderRequest){
        return  orderDao.selectOrder(orderRequest);

    }
}
