package com.flab.kream.order.dao;

import com.flab.kream.order.dto.OrderRequestDTO;
import com.flab.kream.order.dto.OrderResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    void addOrder(OrderRequestDTO orderRequest);

    OrderResponseDTO selectOrder(OrderRequestDTO orderRequest);

}
