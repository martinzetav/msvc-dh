package com.microservice.product.controller;

import com.microservice.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public Product getProduct(@RequestParam String id){
        return Product.builder()
                .id(id)
                .name("Notebook")
                .price(2000.0)
                .instance("Instance 1")
                .build();
    }


}
