package com.flab.kream.order.mapper;

import com.flab.kream.order.dto.OrderRequestDTO;
import com.flab.kream.order.dto.OrderResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void addOrder(OrderRequestDTO orderRequest);
    OrderResponseDTO selectOrder(OrderRequestDTO orderRequest);
}
