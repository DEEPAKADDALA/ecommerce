package com.ecommerce.project.controller;

import com.ecommerce.project.payload.OrderDTO;
import com.ecommerce.project.payload.OrderRequestDTO;
//import com.ecommerce.project.payload.StripePaymentDTO;
import com.ecommerce.project.service.OrderService;
//import com.ecommerce.project.service.StripeService;
import com.ecommerce.project.util.AuthUtil;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Autowired
//    private StripeService stripeService;

    @Autowired
    private AuthUtil authUtil;

    @PostMapping("/orders/users/payments/{paymentMethod}")
    public ResponseEntity<OrderDTO> orderProducts(@PathVariable String paymentMethod, @RequestBody OrderRequestDTO orderRequestDTO) {
        String emailId=authUtil.loggedInEmail();
        OrderDTO order=orderService.placeOrder(emailId,orderRequestDTO.getAddressId(),paymentMethod,orderRequestDTO.getPaymentGatewayName(),
                orderRequestDTO.getPaymentGatewayPaymentId(),orderRequestDTO.getPaymentGatewayStatus(),orderRequestDTO.getPaymentGatewayResponseMessage()
        );
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }

//    @PostMapping("/order/stripe-client-secret")
//    public ResponseEntity<String> createStripeClientSecret(@RequestBody StripePaymentDTO stripePaymentDTO) throws StripeException {
//        PaymentIntent paymentIntent=stripeService.paymentIntent(stripePaymentDTO);
//        return new ResponseEntity<>(paymentIntent.getClientSecret(),HttpStatus.CREATED);
//    }
}
