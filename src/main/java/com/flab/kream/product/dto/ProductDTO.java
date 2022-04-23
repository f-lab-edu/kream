package com.flab.kream.product.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private Integer productId;

    @NotBlank
    private Integer brandId;

    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    @Min(value = 0, message = "정확한 가격을 입력해주세요")
    private String price;

}