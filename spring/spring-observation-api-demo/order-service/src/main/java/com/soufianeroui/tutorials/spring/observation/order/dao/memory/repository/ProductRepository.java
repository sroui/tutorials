package com.soufianeroui.tutorials.spring.observation.order.dao.memory.repository;

import com.soufianeroui.tutorials.spring.observation.order.model.Order;
import reactor.core.publisher.Flux;

public interface ProductRepository {
    Flux<Order> findAll();
}
