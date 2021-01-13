package excelIter;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/12/04 19:57
 */
@ComponentScan("excelIter")
@Configuration
@EnableAspectJAutoProxy
public class MsgTest {


    public static void main(String[] args) {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MsgTest.class);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MsgTest.class);
        MsgService msgService = ac.getBean(MsgService.class);
        msgService.test();
    }
}
