package JUCPack;

import java.util.concurrent.TimeUnit;
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
        System.out.println("生产者： increment");
        try {
            lock.lock();
            while (number != 0) {
                System.out.println("生产者： await");
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t 生产者生成： " + number);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者： increment---unlock\n");
            lock.unlock();
        }
    }

    public void decrement() {
        System.out.println("消费者者： decrement");
        try {
            lock.lock();
            while (number == 0) {
                System.out.println("消费者者： await");
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t 消费者者消费： " + number);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者者： decrement---unlock \n");
            lock.unlock();
        }
    }

}

public class ProdConsumerTraditionDemo {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        MyData myData = new MyData();
//        try {
//            myData.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                myData.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                myData.decrement();
            }
        }, "B").start();
    }


}
