package gg.code.PaymentKafkaConsumer.listener;

import gg.code.PaymentKafkaConsumer.models.Payment;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonConsumerListener {

//    @KafkaListener(groupId = "0", topics = "payment-topic", containerFactory = "jsonContainerFactory")
//    public void paymentListener(@Payload Payment payment) {
//        log.info("PAYMENT RECEIVED ::: {}", payment);
//        log.info("DATA RECEIVED ::: {}", payment.ge);
//    }

    @KafkaListener(groupId = "0", topics = "payment-topic", containerFactory = "jsonContainerFactory")
    public void detailedListener(ConsumerRecord<String, Payment> record) {
        Payment message = record.value();
        log.info("PAYMENT RECEIVED ::: {}", message);
        log.info("MESSAGE DATA ::: {}, {}, {}, {}", record.timestamp(), record.offset(), record.partition(), record.topic());
    }

}
