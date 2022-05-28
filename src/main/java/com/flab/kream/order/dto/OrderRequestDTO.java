package com.flab.kream.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
