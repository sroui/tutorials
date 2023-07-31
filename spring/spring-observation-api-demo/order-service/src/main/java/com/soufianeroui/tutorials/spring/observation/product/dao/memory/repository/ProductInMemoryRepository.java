package com.soufianeroui.tutorials.spring.observation.product.dao.memory.repository;

import com.soufianeroui.tutorials.spring.observation.product.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ProductInMemoryRepository implements ProductRepository {

    @Override
    public Flux<Product> findAll() {
        Product productOne = new Product();
        productOne.setId(777L);
        productOne.setName("Bike");

        Product productTwo = new Product();
        productTwo.setName("Chocolate");
        productTwo.setId(555L);

        return Flux.just(productOne, productTwo);
    }
}
