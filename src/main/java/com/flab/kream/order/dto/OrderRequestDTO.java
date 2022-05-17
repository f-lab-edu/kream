package com.flab.kream.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OrderRequestDTO {

    @Min(value = 0, message = "멤버 아이디를 입력해주세요")
    private long memberId;

    @Min(value = 0, message = "상품아이디를 입력해주세요")
    private long productId;

    @Min(value = 0, message = "수량을 입력해주세요")
    private int quantity;

    @NotBlank(message = "등록자를 입력해주세요")
    private String createdBy;
}
