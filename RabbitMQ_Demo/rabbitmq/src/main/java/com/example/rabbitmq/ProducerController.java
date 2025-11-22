package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rabbitmq.Constants.EXCHANGE_NAME;
import static com.example.rabbitmq.Constants.ROUTING_KEY;

@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/msg")
    public String sendMsg(@RequestBody Person person) {
        System.out.println("send msg");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, person);
        return "success";
    }
}
