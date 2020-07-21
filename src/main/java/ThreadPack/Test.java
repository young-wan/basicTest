package ThreadPack;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author Young
 * @create 2020-04-17 10:21
 * @desc exam
 * {@link}
 **/
public class Test {
    public static void main(String[] args) {

//        Person person = new Person();
//        new Thread(() -> {
//            String name = Thread.currentThread().getName();
//            while (true) {
//                if (person.count < 5) {
//                    System.out.println("产品不足," + name + "开始生产");
//                    person.count++;
//                    System.out.println("当前有产品," + person.count + "个");
//                } else if (person.count >= 5) {
//                    System.out.println("产能过剩," + name + "停止生产");
//                    try {
//                        person.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "chief").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String name = Thread.currentThread().getName();
//                while (true) {
//                    if (person.count <= 0) {
//                        System.out.println("产品不足," + name + "停止消费");
//                        person.notify();
//                    } else if (person.count >= 5) {
//                        System.out.println("产品过剩," + name + "开始消费");
//                        System.out.println("当前有产品," + person.count + "个");
//                        person.count--;
//                    }
//                }
//            }
//        }, "customer").start();
//

        ThreadLocal<Person> p1 = new ThreadLocal<>();
        ThreadLocal<Person> p2 = new ThreadLocal<>();
        ThreadLocal<Person> p3 = new ThreadLocal<>();
        p1.set(new Person("p1", 1));
        p1.set(new Person("p11", 11));
        System.out.println(p1.get());
        System.out.println("----------");
        p2.set(new Person("p2", 2));
        System.out.println(p1.get());
        System.out.println(p2.get());
        System.out.println("----------");
        p3.set(new Person("p3", 3));
        System.out.println(p1.get());
        System.out.println(p2.get());
        System.out.println(p3.get());

        System.out.println(Thread.currentThread().getName() + ":" +p1);
        System.out.println(Thread.currentThread().getName() + ":" +p2);
        System.out.println(Thread.currentThread().getName() + ":" +p3);
        p1.remove();
        p2.remove();
        p3.remove();
    }
}


class Person {
//    public static int count = 0;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}