package JUCPack;

import java.util.concurrent.TimeUnit;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/20 13:36
 */

class MyLockData implements Runnable {

    private String lockA;
    private String lockB;

    public MyLockData(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 持有" + lockA + "尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 持有" + lockB + "尝试获取" + lockA);
            }
        }
    }
}

public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyLockData(lockA, lockB), "Thread-A").start();


        new Thread(new MyLockData(lockB, lockA), "Thread-B").start();
    }

}
