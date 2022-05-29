package com.flab.kream.product.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    private long productId;
    @NotNull(message = "상품의 브랜드를 선택해주세요")
    private long brandId;
    @NotBlank(message = "상품명을 입력해주세요")
    private String name;
    @NotBlank(message = "이미지를 업로드해주세요")
    private String imageUrl;
    @Min(value = 0, message = "정확한 가격을 입력해주세요")
    private BigDecimal price;
}
