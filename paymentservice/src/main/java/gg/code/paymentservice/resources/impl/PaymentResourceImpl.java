package gg.code.paymentservice.resources.impl;

import gg.code.paymentservice.model.Payment;
import gg.code.paymentservice.resources.PaymentResource;
import gg.code.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResourceImpl implements PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> postPayment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
