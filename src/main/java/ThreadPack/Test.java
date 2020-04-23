package ThreadPack;

/**
 * @author Young
 * @create 2020-04-17 10:21
 * @desc exam
 * {@link}
 **/
public class Test {
    public static void main(String[] args) {

        Person person = new Person();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            while (true) {
                if (person.count < 5) {
                    System.out.println("产品不足," + name + "开始生产");
                    person.count++;
                    System.out.println("当前有产品," + person.count + "个");
                } else if (person.count >= 5) {
                    System.out.println("产能过剩," + name + "停止生产");
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "chief").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                while (true) {
                    if (person.count <= 0) {
                        System.out.println("产品不足," + name + "停止消费");
                        person.notify();
                    } else if (person.count >= 5) {
                        System.out.println("产品过剩," + name + "开始消费");
                        System.out.println("当前有产品," + person.count + "个");
                        person.count--;
                    }
                }
            }
        }, "customer").start();


    }
}


class Person {
    public static int count = 0;
}