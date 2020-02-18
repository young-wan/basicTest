package resume_practice;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 14:36
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in ");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
        System.out.println(thread.getName() + "\t lock ");
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t invoke myUnlock() ");
    }

    public static void main(String[] args) {
        SpinLockDemo demo = new SpinLockDemo();
        new Thread(() -> {
            demo.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.myUnlock();
        }, "A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            demo.myLock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.myUnlock();
        }, "B").start();
    }

}
