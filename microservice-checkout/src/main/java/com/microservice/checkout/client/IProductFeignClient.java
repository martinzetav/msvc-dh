package com.microservice.checkout.client;

import com.microservice.checkout.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-product")
public interface IProductFeignClient {

    @GetMapping("/products")
    ProductDTO getProductById(@RequestParam String id);
}
