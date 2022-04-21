package com.flab.kream.order.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private int orderId;
    private int memberId;
    private int productId;
    private int quantity;
    private String createdBy;
    private String updatedBy;

}
