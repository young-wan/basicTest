package JUCPack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/20 14:22
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        Integer count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService threadPool = new ThreadPoolExecutor(
                count,
                count + 1,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );


        try {
            for (int i = 1; i <= 30; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理业务" + atomicInteger.incrementAndGet());
                });
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
