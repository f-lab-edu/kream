package com.flab.kream.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OrderRequestDTO {

    @Min(value = 1, message = "memberId must not be zero")
    private long memberId;

    @Min(value = 1, message = "productId must not be zero")
    private long productId;

    @Min(value = 1, message = "quantity must not be zero")
    private int quantity;

    @NotBlank(message = "createdBy must not be null")
    private String createdBy;
}
