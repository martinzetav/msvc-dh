package com.microservice.checkout.service.impl;

import com.microservice.checkout.client.IProductFeignClient;
import com.microservice.checkout.dto.ProductDTO;
import com.microservice.checkout.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductFeignClient productFeignClient;

    @Override
    public ProductDTO getProduct(String id) {
        return productFeignClient.getProductById(id);
    }
}
