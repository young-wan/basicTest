package excelIter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/12/04 19:49
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MsgInter {
}
