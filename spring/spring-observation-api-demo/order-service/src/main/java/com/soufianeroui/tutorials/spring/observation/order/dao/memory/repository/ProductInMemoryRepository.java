package com.soufianeroui.tutorials.spring.observation.order.dao.memory.repository;

import com.soufianeroui.tutorials.spring.observation.order.model.Order;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ProductInMemoryRepository implements ProductRepository {

    @Override
    public Flux<Order> findAll() {
        Order orderOne = new Order();
        orderOne.setId(777L);
        orderOne.setName("Bike");

        Order orderTwo = new Order();
        orderTwo.setName("Chocolate");
        orderTwo.setId(555L);

        return Flux.just(orderOne, orderTwo);
    }
}
