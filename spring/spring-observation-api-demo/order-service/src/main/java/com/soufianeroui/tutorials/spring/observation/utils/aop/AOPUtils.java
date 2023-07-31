package com.soufianeroui.tutorials.spring.observation.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Defines AOP utility methods
 *
 * @author Soufiane Roui
 */
public class AOPUtils {

    public static Object proceed(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private AOPUtils() {
        throw new UnsupportedOperationException();
    }
}
