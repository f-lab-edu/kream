package com.flab.kream.order.service;

import com.flab.kream.member.mapper.MemberMapper;
import com.flab.kream.order.mapper.OrderMapper;
import com.flab.kream.order.dto.OrderRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;

    @Transactional
    public void addOrder(OrderRequestDTO orderRequest) {
        int reuslt = memberMapper.selectMemberIdCnt(orderRequest.getMemberId());
        if(reuslt == 1){
            orderMapper.addOrder(orderRequest);
        }
    }
}