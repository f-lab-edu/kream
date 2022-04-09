package com.flab.kream.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int productId;

    private int brandId;

    private String name;

    private String imageUrl;

    private String price;

}
