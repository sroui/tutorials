package com.soufianeroui.tutorials.spring.observation.observation.metrics;

import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import com.soufianeroui.tutorials.spring.observation.utils.aop.AOPUtils;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

import static com.soufianeroui.tutorials.spring.observation.observation.metrics.MetricsConstants.PRODUCTS_COUNT_TASK_METRIC_NAME;

@Aspect
@Component
@RequiredArgsConstructor
public class MetricsAspect {
    private final ObservationRegistry observationRegistry;

    @Pointcut("execution(* com.soufianeroui.tutorials.spring.observation.order.service.OrderService.createOrder())")
    public void fetchProductsPointcut() { //NOSONAR
    }

    @Pointcut("bean(ordersCountTask)")
    public void productsCountTaskPointcut() { //NOSONAR
    }

    @SuppressWarnings("unchecked")
//    @Around("fetchProductsPointcut()")
    public Flux<OrderDto> observeFetchedProducts(ProceedingJoinPoint proceedingJoinPoint) {
        Supplier<Flux<OrderDto>> productFluxSupplier = () -> (Flux<OrderDto>) AOPUtils.proceed(proceedingJoinPoint);
        //todo end-to-end reactive
        return null;
    }

    @Around("productsCountTaskPointcut()")
    public void observeProductsCountTask(ProceedingJoinPoint proceedingJoinPoint) {
        Observation.createNotStarted(PRODUCTS_COUNT_TASK_METRIC_NAME, observationRegistry)
                .observe(() -> AOPUtils.proceed(proceedingJoinPoint));
    }
}
