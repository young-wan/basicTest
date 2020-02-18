package resume_practice;

import java.util.concurrent.CountDownLatch;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 14:57
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t  离开--");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "\t 结束");
    }

}
