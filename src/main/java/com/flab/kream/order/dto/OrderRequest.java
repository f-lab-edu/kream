package com.flab.kream.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OrderRequest {

    private int memberId;
    private int productId;
    private int quantity;

    @NotBlank(message = "createdBy must not be null")
    private String createdBy;
}
