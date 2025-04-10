package com.microservice.checkout.service.impl;

import com.microservice.checkout.client.IProductFeignClient;
import com.microservice.checkout.dto.ProductDTO;
import com.microservice.checkout.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductFeignClient productFeignClient;

    Logger log = LoggerFactory.getLogger(ProductService.class);

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallbackMethod")
    public ProductDTO getProduct(String id) {
        return productFeignClient.getProductById(id, true);
    }

    public ProductDTO getProductFallbackMethod(String id, Exception e){
        if (e instanceof CallNotPermittedException) {
            log.error("Circuit Breaker bloqueó la llamada - Estado: OPEN");
        } else {
            log.error("Fallback por error en llamada: " + e.getMessage());
        }

        return  ProductDTO.builder()
                .id("fallback-" + id)
                .name("Producto no disponible")
                .price(0.0)
                .build();
    }
}
