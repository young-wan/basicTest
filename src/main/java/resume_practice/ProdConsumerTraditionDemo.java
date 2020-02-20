package resume_practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/20 10:11
 */
class MyData {
    private Integer number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() {

        try {
            lock.lock();
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t 生产者生成： " + number);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        try {
            lock.lock();
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t 消费者者消费： " + number);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ProdConsumerTraditionDemo {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        MyData myData = new MyData();
//        new Thread(() -> {
//            for (int i = 1; i <= 5; i++) {
//                myData.increment();
//            }
//        }, "A").start();
//        new Thread(() -> {
//            for (int i = 1; i <= 5; i++) {
//                myData.decrement();
//            }
//        }, "B").start();
    }


}