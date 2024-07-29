package gg.code.paymentservice.resources;

import gg.code.paymentservice.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

    @PostMapping
    ResponseEntity<Payment> postPayment(@RequestBody Payment payment);

}
