package com.flab.kream.order.dao;

import com.flab.kream.order.dto.OrderRequest;
import com.flab.kream.order.dto.OrderResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    void addOrder(OrderRequest orderRequest);
    OrderResponse selectOrder(OrderRequest orderRequest);

}
