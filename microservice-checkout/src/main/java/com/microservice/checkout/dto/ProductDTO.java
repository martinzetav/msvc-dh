package com.microservice.checkout.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String id;
    private String name;
    private Double price;
    private String instance;
}
