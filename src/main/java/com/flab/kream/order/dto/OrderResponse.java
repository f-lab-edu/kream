package com.flab.kream.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private int orderId;
    private int memberId;
    private int productId;
    private int quantity;
    private String createdBy;

}
