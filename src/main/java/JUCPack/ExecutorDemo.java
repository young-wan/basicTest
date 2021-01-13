package JUCPack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/20 13:58
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        /**
         * ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler) {
         */

        /**
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
         */
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        /**
         * new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        /**
         * (new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
         */
        ExecutorService singleTreadPool = Executors.newSingleThreadExecutor();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //模拟10个用户来办理业务 没有用户就是来自外部的请求线程.
        try {
            for (int i = 1; i <= 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
//                try {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }



    }
}
