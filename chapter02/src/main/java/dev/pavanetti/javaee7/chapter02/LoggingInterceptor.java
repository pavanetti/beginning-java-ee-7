package dev.pavanetti.javaee7.chapter02;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        String className = ic.getTarget().getClass().getName();
        String methodName = ic.getMethod().getName();
        logger.entering(className, methodName);
        try {
            return ic.proceed();
        } finally {
            logger.exiting(className, methodName);
        }
    }
}
