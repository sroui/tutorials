package com.soufianeroui.tutorials.spring.observation.product.web.router;

import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
import com.soufianeroui.tutorials.spring.observation.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class ProductApiRouterConfiguration {
    private final ProductService productService;

    @Bean
    RouterFunction<ServerResponse> findAllRoute() {
        return route(GET("api/products/"),
                req -> ok().body(productService.findAll(), ProductDto.class));
    }
}
