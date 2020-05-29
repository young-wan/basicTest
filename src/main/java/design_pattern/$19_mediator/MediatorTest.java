package design_pattern.$19_mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author young
 * @Date 2020/5/29 9:05
 * @Desc 中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。
 **/
public class MediatorTest {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);
        colleague1.send();
        System.out.println("--------------");
        colleague2.send();
    }

}

// 抽象中介者
abstract class Mediator {
    // 注册
    public abstract void register(Colleague colleague);

    // 转发
    public abstract void relay(Colleague colleague);
}

// 具体中介者
class ConcreteMediator extends Mediator {
    // 定义一个 List 来管理同事对象
    private List<Colleague> list = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!list.contains(colleague)) {
            list.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague cl : list) {
            if (!cl.equals(colleague)) {
                cl.receive();
            }
        }
    }
}

//抽象同事类
abstract class Colleague {
    //保存中介者对象
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

//具体同事类
class ConcreteColleague1 extends Colleague {

    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}

class ConcreteColleague2 extends Colleague {

    @Override
    public void receive() {
        System.out.println("具体同事类2收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(this);
    }
}