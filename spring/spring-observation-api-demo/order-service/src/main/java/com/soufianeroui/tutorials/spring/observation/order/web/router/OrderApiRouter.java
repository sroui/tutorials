package com.soufianeroui.tutorials.spring.observation.order.web.router;

import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import com.soufianeroui.tutorials.spring.observation.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class OrderApiRouter {

    @Bean
    RouterFunction<ServerResponse> orderRoutes(OrderService orderService) {
        var orderHandler = new OrderHandler(orderService);
        return route()
                .POST("/orders", orderHandler::createOrder)
                // You can add other routes here
                .build();
    }


    @RequiredArgsConstructor
    public static class OrderHandler {
        private final OrderService orderService;

        public Mono<ServerResponse> createOrder(ServerRequest request) {
            return ok().body(orderService.createOrder(request.bodyToMono(OrderDto.class)), OrderDto.class);
        }
    }
}
