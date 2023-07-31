package com.soufianeroui.tutorials.spring.observation.observation.metrics;

import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
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

    @Pointcut("execution(* com.soufianeroui.tutorials.spring.observation.product.service.ProductService.findAll())")
    public void fetchProductsPointcut() { //NOSONAR
    }

    @Pointcut("bean(productsCountTask)")
    public void productsCountTaskPointcut() { //NOSONAR
    }

    @SuppressWarnings("unchecked")
//    @Around("fetchProductsPointcut()")
    public Flux<ProductDto> observeFetchedProducts(ProceedingJoinPoint proceedingJoinPoint) {
        Supplier<Flux<ProductDto>> productFluxSupplier = () -> (Flux<ProductDto>) AOPUtils.proceed(proceedingJoinPoint);
        //todo end-to-end reactive
        return null;
    }

    @Around("productsCountTaskPointcut()")
    public void observeProductsCountTask(ProceedingJoinPoint proceedingJoinPoint) {
        Observation.createNotStarted(PRODUCTS_COUNT_TASK_METRIC_NAME, observationRegistry)
                .observe(() -> AOPUtils.proceed(proceedingJoinPoint));
    }
}
