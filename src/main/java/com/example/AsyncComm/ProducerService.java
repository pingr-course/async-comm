package com.example.AsyncComm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Value(value = "${topic.random-messages}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendMessage(String message) {
        this.template.send(this.topic, message);
    }
}
