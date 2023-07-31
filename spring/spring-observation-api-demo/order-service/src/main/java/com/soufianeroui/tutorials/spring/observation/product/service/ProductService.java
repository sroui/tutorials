package com.soufianeroui.tutorials.spring.observation.product.service;

import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
import io.micrometer.observation.annotation.Observed;
import reactor.core.publisher.Flux;

public interface ProductService {
    Flux<ProductDto> findAll();
}
