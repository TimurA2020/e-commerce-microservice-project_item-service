package com.microserviceproject.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemDto {
    private String title;
    private String description;
    private BigDecimal price;

}
