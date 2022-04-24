package com.flab.kream.order.dao;

import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderDao {
    public OrderResponse addOrder(OrderRequest orderRequest);
    public OrderResponse selectOrder(OrderRequest orderRequest);
}
