package com.flab.kream.order.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private int memberId;
    private int productId;
    private int quantity;
    private String createdBy;

}
