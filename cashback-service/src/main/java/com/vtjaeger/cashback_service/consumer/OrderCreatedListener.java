package com.vtjaeger.cashback_service.consumer;

import com.vtjaeger.cashback_service.dtos.OrderCreatedDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {
    @RabbitListener(queues = "order-create-cashback")
    public void onOrderCreated(OrderCreatedDto dto) {
        System.out.println("id recebido: " + dto.getId());
        System.out.println("valor recebido: " + dto.getValue());
    }
}
