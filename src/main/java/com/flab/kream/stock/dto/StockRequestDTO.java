package com.flab.kream.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRequestDTO {
    @Min(value = 0, message = "상품아이디를 입력해주세요")
    private long productId;
}
