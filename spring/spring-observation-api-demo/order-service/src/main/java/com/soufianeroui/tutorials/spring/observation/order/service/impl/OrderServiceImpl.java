package com.soufianeroui.tutorials.spring.observation.order.service.impl;

import com.soufianeroui.tutorials.spring.observation.order.dao.memory.repository.ProductRepository;
import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import com.soufianeroui.tutorials.spring.observation.order.dto.assembler.OrderDtoAssembler;
import com.soufianeroui.tutorials.spring.observation.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductRepository productRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public Flux<OrderDto> order() {
        return productRepository.findAll().map(orderDtoAssembler::assemble);
    }

    @Override
    public Flux<OrderDto> createOrder(Mono<OrderDto> order) {
        return null;
    }
}
