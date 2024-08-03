package com.vtjaeger.order_service.controller;

import com.vtjaeger.order_service.dtos.OrderCreatedDto;
import com.vtjaeger.order_service.model.Order;
import com.vtjaeger.order_service.repository.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public Order create(@RequestBody Order order) {
        orderRepository.save(order);
        OrderCreatedDto dto = new OrderCreatedDto(order.getId(), order.getValue());
        rabbitTemplate.convertAndSend("order-create", "", dto);

        return order;
    }

    @GetMapping
    public Collection<Order> list(){
        return orderRepository.findAll();
    }

    @PutMapping("{id}/pay")
    public Order pay(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.markAsPaid();
        return orderRepository.save(order);
    }
}
