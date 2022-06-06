package dev.pavanetti.javaee7.chapter02;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
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
