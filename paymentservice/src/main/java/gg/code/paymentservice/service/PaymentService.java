package gg.code.paymentservice.service;

import gg.code.paymentservice.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Service
@Log4j2
public class PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    public void sendPayment(Payment payment){
        log.info("PAYMENT_SERVICE_IMPL ::: Payment received {}", payment);
        Thread.sleep(1000);

        log.info("Enviando pagamento");
        kafkaTemplate.send("payment-topic", payment);
    }

}
