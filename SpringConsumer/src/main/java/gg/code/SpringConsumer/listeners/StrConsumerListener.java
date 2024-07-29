package gg.code.SpringConsumer.listeners;

import gg.code.SpringConsumer.custom.StrCustomConsumerListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrCustomConsumerListener(groupId = "group-0")
    public void listener(String message) {
        log.info("1 ::: Receive message {}", message);
    }

    @SneakyThrows
    @StrCustomConsumerListener(groupId = "group-1")
    public void listener2(String message) {
        log.info("2 ::: Receive message {}", message);
        throw new IllegalAccessException("EXCEPTION...");
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageFactory")
    public void listener3(String message) {
        log.info("3 ::: Receive message {}", message);

    }
}
