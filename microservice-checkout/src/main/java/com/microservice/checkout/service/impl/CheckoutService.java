package com.microservice.checkout.service.impl;

import com.microservice.checkout.dto.ProductDTO;
import com.microservice.checkout.model.Checkout;
import com.microservice.checkout.service.ICheckoutService;
import com.microservice.checkout.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutService implements ICheckoutService {

    private final IProductService productService;

    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id: productIds){
            ProductDTO product = productService.getProduct(id);
            total += product.getPrice();
        }

//        Double total = productIds.stream()
//                .map(id -> productService.getProduct(id))
//                .map(ProductDTO::getPrice)
//                .reduce(0.0, Double::sum);


        return Checkout.builder()
                .id("234")
                .url("www.digitalhouse.com/checkout")
                .totalAmount(String.valueOf(total))
                .build();
    }
}
