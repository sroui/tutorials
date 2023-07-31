package com.soufianeroui.tutorials.spring.observation.product.service.impl;

import com.soufianeroui.tutorials.spring.observation.product.dao.memory.repository.ProductRepository;
import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
import com.soufianeroui.tutorials.spring.observation.product.dto.assembler.ProductAssembler;
import com.soufianeroui.tutorials.spring.observation.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;

    @Override
    public Flux<ProductDto> findAll() {
        return productRepository.findAll().map(productAssembler::assemble);
    }
}
