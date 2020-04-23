package excelIter;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Young
 * @create 2020-03-02 11:32
 * @desc leetcode
 * {@link}
 **/
@Component
public class MsgService {
    public void test() {
        System.out.println("msgService  test  invoke");
    }   
}
