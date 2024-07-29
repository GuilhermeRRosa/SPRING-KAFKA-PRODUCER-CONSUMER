package gg.code.paymentservice.service;

import gg.code.paymentservice.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentService {

    public void sendPayment(Payment payment){
        log.info("PAYMENT_SERVICE_IMPL ::: Payment received {}", payment);
    }

}
