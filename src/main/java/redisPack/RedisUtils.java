package redisPack;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.tomcat.util.net.NioChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author Young
 * @create 2020-04-18 14:48
 * @desc exam
 * {@link}
 **/
public class RedisUtils {

    public static void main(String[] args) {
//        Son son = new Son();
//        son.bar();
//        System.out.println(ObjectSizeCalculator.getObjectSize(son));
        ApplicationContext context = new ClassPathXmlApplicationContext("/Beans.xml");
//        context.getBean("RedisUtils");
        System.out.println(context.getBeanDefinitionNames());
        context.getParentBeanFactory();
        RedisUtils redisUtils = new RedisUtils();

    }

}

class Father {

    static int i;

    static {
        i = 3;
        System.out.println(i);
    }

    protected int age;

    protected void showInfo() {
        System.out.println("age = " + this.age);
    }

    protected Integer getAgeInfo() {
        return this.age;
    }

}

class Son extends Father {
    private int id;

    private String age;


    public void bar() {
        super.age = 10;
        super.showInfo();
    }
}
