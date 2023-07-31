package com.soufianeroui.tutorials.spring.observation.product.task;

import com.soufianeroui.tutorials.spring.observation.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductsCountTask {
    private final ProductService productService;

    @Scheduled(fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void count() {
        productService.findAll()
                .subscribeOn(Schedulers.parallel()) //todo give a name to the threads
                .count()
                .subscribe(totalNumber -> log.info("Products database contains {} product(s)", totalNumber));
    }
}
