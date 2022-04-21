package com.flab.kream.order.dao;

import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    public OrderResponse addOrder(OrderRequest orderRequest){
        return addOrder(orderRequest);
    }
}
