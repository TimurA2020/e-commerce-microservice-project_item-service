package com.microserviceproject.productservice.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document (value = "items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Item {

    @Id
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
}
