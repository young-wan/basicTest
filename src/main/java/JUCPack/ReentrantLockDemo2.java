package JUCPack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 13:57
 */
class Phone2 implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t get");
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t set");
        lock.unlock();
    }
}

public class ReentrantLockDemo2 {

    public static void main(String[] args) {

        Phone2 phone2 = new Phone2();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                phone2.get();
            }, String.valueOf(i)).start();
        }
    }

}
