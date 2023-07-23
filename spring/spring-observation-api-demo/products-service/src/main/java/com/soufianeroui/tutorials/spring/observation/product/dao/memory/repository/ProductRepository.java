package com.soufianeroui.tutorials.spring.observation.product.dao.memory.repository;

import com.soufianeroui.tutorials.spring.observation.product.model.Product;
import reactor.core.publisher.Flux;

public interface ProductRepository {
    Flux<Product> findAll();
}
