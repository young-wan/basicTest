package design_pattern.$18_observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author young
 * @Date 2020/5/28 19:37
 * @Desc 观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。
 **/
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
    }

}

interface Observer {
    void response();
}

class Observer1 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}

class Observer2 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}

abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObserver();
}

class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Object obj : observers) {
            ((Observer) obj).response();
        }
    }
}
