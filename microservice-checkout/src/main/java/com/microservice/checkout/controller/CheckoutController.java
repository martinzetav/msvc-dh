package com.microservice.checkout.controller;

import com.microservice.checkout.model.Checkout;
import com.microservice.checkout.service.ICheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkouts")
@RequiredArgsConstructor
public class CheckoutController {

    private final ICheckoutService checkoutService;

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-from") String requestFrom){
        System.out.println("Enviado desde: " + requestFrom);
        if(!requestFrom.equals("gateway")) return null;
        return checkoutService.buildCheckout(productIds);
    }

}
