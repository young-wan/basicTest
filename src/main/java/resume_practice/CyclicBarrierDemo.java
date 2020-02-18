package resume_practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 15:00
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("开始开会"));
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 到达");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }

}
