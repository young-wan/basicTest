package excelIter;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("@annotation(MsgInter)")
    public void msgOnly() {
        System.out.println("msgOnly---");
    }

    @Before("msgOnly()")
    public void beforeOnly() {
        System.out.println("before----");
    }

    @After("msgOnly()")
    public void afterOnly() {
        System.out.println("after----");
    }
}
