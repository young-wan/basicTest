package excelIter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/12/04 19:55
 */
@Aspect
@Component
public class MsgAspect {

    @Pointcut("execution(* excelIter.MsgService.*(..))")
    public void msgOnly() { }

    @Before("msgOnly()")
    public void beforeOnly() {
        System.out.println("before----");
    }

    @After("msgOnly()")
    public void afterOnly() {
        System.out.println("after----");
    }

    @Around("msgOnly()")
    public Object aroundOnlhy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around ---");
        proceedingJoinPoint.proceed();
        return null;
    }

//    @AfterThrowing("msgOnly()")
//    public void afterException() {
//        System.out.println("afterException ---");
//    }
//
//    @AfterReturning("msgOnly()")
//    public void AfterReturning() {
//        System.out.println("AfterReturning ---");
//    }
}
