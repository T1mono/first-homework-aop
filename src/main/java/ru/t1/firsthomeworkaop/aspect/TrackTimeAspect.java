package ru.t1.firsthomeworkaop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.t1.firsthomeworkaop.model.LogInfo;
import ru.t1.firsthomeworkaop.repository.LogInfoRepository;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final LogInfoRepository logInfoRepository;

    @Pointcut("execution(@ru.t1.firsthomeworkaop.annotation.TrackTime * get*(..))")
    public void trackTimePointcut() {
    }

    @Around("trackTimePointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        LogInfo logInfo = new LogInfo();

        long startTime = System.currentTimeMillis();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        log.info("Метод {} выполнился за {} мс с результатом {}", methodName, endTime - startTime, result);

        logInfo.setNameMethod(methodName);
        logInfo.setDuration(endTime - startTime);
        logInfoRepository.save(logInfo);

        return result;
    }
}
