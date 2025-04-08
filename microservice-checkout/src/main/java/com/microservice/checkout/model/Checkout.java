package com.microservice.checkout.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Checkout {
    private String id;
    private String url;
    private String totalAmount;
    private List<String> availableMethods;

    public Checkout(String id){
        this.id = id;
    }
}
