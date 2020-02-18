package resume_practice;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 13:39
 */
class Phone {
    public synchronized void sendA() {
        System.out.println(Thread.currentThread().getName() + "\t invoke sendAAAAAAA");
        sendB();
    }

    public synchronized void sendB() {
        System.out.println(Thread.currentThread().getName() + "\t invoke sendBBBBBBBB");
    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendA();
        }, "A").start();


        new Thread(() -> {
            phone.sendA();
        }, "B").start();
    }

}
