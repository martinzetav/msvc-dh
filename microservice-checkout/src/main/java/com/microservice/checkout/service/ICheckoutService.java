package com.microservice.checkout.service;

import com.microservice.checkout.model.Checkout;

import java.util.List;

public interface ICheckoutService {
    Checkout buildCheckout(List<String> productIds);
}
