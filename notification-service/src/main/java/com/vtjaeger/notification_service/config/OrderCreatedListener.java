package com.vtjaeger.notification_service.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {
    @RabbitListener(queues = "order-create-notification")
    public void onOrderCreated(OrderCreatedDto dto) {
        System.out.println("id recebido: " + dto.getId());
        System.out.println("valor recebido: " + dto.getValue());
    }
}
