package com.soufianeroui.tutorials.spring.observation.order.task;

import com.soufianeroui.tutorials.spring.observation.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrdersCountTask {
    private final OrderService orderService;

    @Scheduled(fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void count() {
//        orderService.createOrder()
//                .subscribeOn(Schedulers.parallel()) //todo give a name to the threads
//                .count()
//                .subscribe(totalNumber -> log.info("Products database contains {} product(s)", totalNumber));
    }
}
