//package com.ecommerce.project.service;
//
//import com.ecommerce.project.payload.StripePaymentDTO;
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//import com.stripe.param.PaymentIntentCreateParams;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class StripeServiceImpl implements StripeService {
//
//    @Value("${stripe.secret.key}")
//    private String stripeApiKey;
//
//    @PostConstruct
//    public void init() {
//        Stripe.apiKey = stripeApiKey;
//    }
//    @Override
//    public PaymentIntent paymentIntent(StripePaymentDTO stripePaymentDTO) throws StripeException {
//        PaymentIntentCreateParams params =
//                PaymentIntentCreateParams.builder().setAmount(stripePaymentDTO.getAmount()).setCurrency(stripePaymentDTO.getCurrency()).build();
//
//        PaymentIntent paymentIntent = PaymentIntent.create(params);
//
//        return paymentIntent;
//    }
//}
