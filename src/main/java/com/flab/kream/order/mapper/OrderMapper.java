package com.flab.kream.order.mapper;

import com.flab.kream.order.dto.OrderRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    void addOrder(OrderRequestDTO orderRequest);
}
