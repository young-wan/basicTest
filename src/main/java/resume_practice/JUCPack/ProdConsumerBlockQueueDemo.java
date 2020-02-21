package resume_practice.JUCPack;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/20 10:20
 */

class MyResource {

    private volatile Boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myAdd() throws InterruptedException {
        String data = null;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "\t 生产者生成成功： " + data);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止活动");
    }

    public void myDel() throws InterruptedException {
        String res = null;
        while (flag) {
            res = blockingQueue.poll(2, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "\t 消费成功 ： " + res);
        }
        System.out.println(Thread.currentThread().getName() + "停止活动");
    }

    public void myStop() {
        flag = false;
    }
}

public class ProdConsumerBlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(() -> {
            try {
                myResource.myAdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                myResource.myDel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "停止活动");
        myResource.myStop();
    }

}
