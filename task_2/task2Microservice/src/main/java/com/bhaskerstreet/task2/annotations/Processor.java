package com.bhaskerstreet.task2.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class Processor {

    private static final Logger LOGGER = LogManager.getLogger(com.bhaskerstreet.task2.annotations.LogMethodParam.class);

    @Around("execution(* *(..)) && @annotation(LogMethodParam)")
    public Object printMethodLogs(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        if (args.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object o : args) {
                stringBuilder.append(o);
            }
            LOGGER.info(stringBuilder.toString());

        }
        Object output = pjp.proceed();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        LogMethodParam myAnnotation = method.getAnnotation(LogMethodParam.class);
        if (myAnnotation.printMethodOutput()) {
            LOGGER.info(output);
        }

        return output;
    }


}
