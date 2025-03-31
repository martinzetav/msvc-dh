package com.microservice.checkout.service;

import com.microservice.checkout.dto.ProductDTO;

public interface IProductService {
    ProductDTO getProduct(String id);
}
