package com.flab.kream.stock.mapper;

import com.flab.kream.stock.dto.StockRequestDTO;
import com.flab.kream.stock.dto.StockResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
    List<StockResponseDTO> selectStock(StockRequestDTO stockRequest);
}
