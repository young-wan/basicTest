package designPattern.ThreadTest;

import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/04 15:45
 */
public class BonusTest {

    private static Integer total = 99;

    private static Integer[] arr = {5, 10, 20, 50, 100, 200};

    private static Random random = new Random();

    static class BonusRun implements Runnable {
        @Override
        public void run() {
            synchronized (total) {
                while (total > 0) {
                    System.out.println(Thread.currentThread().getName() + ":  " + (100 - total) + "产生了一个大奖: " + arr[random.nextInt(6)]);
                    total--;
                    System.out.println("------------------------------");
                }
            }
        }
    }

    public static void main(String[] args) {
        BonusRun br = new BonusRun();
        Thread t1 = new Thread(br, "抽奖箱1");
        Thread t2 = new Thread(br, "抽奖箱2");
        t1.start();
        t2.start();
    }

}

