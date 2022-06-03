package com.flab.kream.stock.service;

import com.flab.kream.stock.dto.StockRequestDTO;
import com.flab.kream.stock.dto.StockResponseDTO;
import com.flab.kream.stock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockMapper stockMapper;

    public List<StockResponseDTO> selectStock(StockRequestDTO stockRequest) {
        return stockMapper.selectStock(stockRequest);
    }
}