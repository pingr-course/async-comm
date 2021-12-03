package com.example.AsyncComm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class KafkaController {
    private final ProducerService producer;

    @Autowired
    public KafkaController(ProducerService producerService) {
        this.producer = producerService;
    }

    @PostMapping
    public String produce(@RequestBody String message) {
        this.producer.sendMessage(message);
        return "Mensagem enviada: " + message;
    }
}
