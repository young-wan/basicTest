package excelIter;

import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Service;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/12/04 19:57
 */
@Service
@EnableSpringConfigured
public class MsgTest {

    @MsgInter
    public static void test() {
        System.out.println("start  test ----");
    }

    public static void main(String[] args) {
        test();
    }
}
