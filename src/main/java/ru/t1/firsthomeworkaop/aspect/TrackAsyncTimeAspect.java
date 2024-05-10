package ru.t1.firsthomeworkaop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import ru.t1.firsthomeworkaop.model.LogInfo;
import ru.t1.firsthomeworkaop.repository.LogInfoRepository;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class TrackAsyncTimeAspect {

    private final LogInfoRepository logInfoRepository;

    @Pointcut(value = "execution(@ru.t1.firsthomeworkaop.annotation.TrackAsyncTime * create*(..))")
    public void trackAsyncTimePointcut() {}

    @Around(value = "trackAsyncTimePointcut()")
    public Object trackAsyncRunner(ProceedingJoinPoint proceedingJoinPoint) {
        LogInfo logInfo = new LogInfo();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        long startTime = System.currentTimeMillis();

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Асинхронный запуск в trackAsyncRunner");
                Object result = proceedingJoinPoint.proceed();
                long endTime = System.currentTimeMillis();
                log.info("Метод {} выполнился за {} мс с результатом {}", methodName, endTime - startTime, result);
                logInfo.setNameMethod(methodName);
                logInfo.setDuration(endTime - startTime);
                logInfoRepository.save(logInfo);
            } catch (Throwable e) {
                log.error("Ошибка trackAsyncRunner", e);
            }
        });
    }
}
