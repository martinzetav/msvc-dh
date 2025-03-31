package com.microservice.checkout.controller;

import com.microservice.checkout.model.Checkout;
import com.microservice.checkout.service.ICheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkouts")
@RequiredArgsConstructor
public class CheckoutController {

    private final ICheckoutService checkoutService;

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productIds){
        return checkoutService.buildCheckout(productIds);
    }

}
