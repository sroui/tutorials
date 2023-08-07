package com.soufianeroui.tutorials.spring.observation.order.service;

import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Flux<OrderDto> createOrder(Mono<OrderDto> order);
}
