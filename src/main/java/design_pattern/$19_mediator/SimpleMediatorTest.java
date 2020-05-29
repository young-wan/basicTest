package design_pattern.$19_mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author young
 * @Date 2020/5/29 9:34
 * @Desc 简单单例中介者
 **/
public class SimpleMediatorTest {
    public static void main(String[] args) {
        SimpleColleague c1,c2;
        c1=new SimpleConcreteColleague1();
        c2=new SimpleConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }
}

class SimpleMediator {
    private static SimpleMediator smd = new SimpleMediator();
    private List<SimpleColleague> list = new ArrayList<>();

    private SimpleMediator() {

    }

    public static SimpleMediator getSmd() {
        return smd;
    }

    public void register(SimpleColleague SimpleColleague) {
        if (!list.contains(SimpleColleague)) {
            list.add(SimpleColleague);
        }
    }

    public void relay(SimpleColleague scl) {
        for (SimpleColleague ob : list) {
            if (!ob.equals(scl)) {
                ob.receive();
            }
        }
    }

}

interface SimpleColleague {
    void receive();

    void send();
}

class SimpleConcreteColleague1 implements SimpleColleague {
    SimpleConcreteColleague1() {
        SimpleMediator smd = SimpleMediator.getSmd();
        smd.register(this);
    }

    @Override
    public void receive() {
        {    System.out.println("具体同事类1：收到请求。");    }
    }

    @Override
    public void send() {
        System.out.println("具体同事类1：发出请求...");
        SimpleMediator smd = SimpleMediator.getSmd();
        smd.relay(this);
    }
}

class SimpleConcreteColleague2 implements SimpleColleague {
    SimpleConcreteColleague2() {
        SimpleMediator smd = SimpleMediator.getSmd();
        smd.register(this);
    }

    @Override
    public void receive() {
        System.out.println("具体同事类2：收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同事类2：发出请求...");
        SimpleMediator smd = SimpleMediator.getSmd();
        smd.relay(this);
    }
}