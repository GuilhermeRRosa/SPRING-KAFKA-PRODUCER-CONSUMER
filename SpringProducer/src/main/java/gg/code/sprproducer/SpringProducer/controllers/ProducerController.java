package gg.code.sprproducer.SpringProducer.controllers;

import gg.code.sprproducer.SpringProducer.services.ProducerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class ProducerController {

    public final ProducerServices producerServices;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        producerServices.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
