package JUCPack;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 15:06
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 进入停车场停车3秒");
                    TimeUnit.MICROSECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "\t 离开停车场");
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

}
