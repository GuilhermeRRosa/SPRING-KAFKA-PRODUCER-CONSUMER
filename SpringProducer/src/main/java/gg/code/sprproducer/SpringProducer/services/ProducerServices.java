package gg.code.sprproducer.SpringProducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProducerServices {

    public final KafkaTemplate<String, String> template;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, String>> future = template.send("str-topic", message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("message delivery with success: {}", message);
                log.info("Partition {}, Offset {}, Topic {}",
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset(),
                        result.getRecordMetadata().topic());
            } else {
                log.error("error while delivering the message to kafka");
            }
        });
    }
}
