package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.rabbitmq.Constants.QUEUE_NAME;

@Component
public class MsgConsumer {

    @RabbitListener(queues = QUEUE_NAME)
    public void handleMsg(Person person) {
        System.out.println("handle msg, id: " + person.getId()
            +", name: " + person.getName());
    }
}
