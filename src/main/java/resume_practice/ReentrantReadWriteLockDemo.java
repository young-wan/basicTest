package resume_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 14:41
 */
class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在写入 : " + key);
        try {
            TimeUnit.MICROSECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        lock.writeLock().unlock();
    }

    public void get(String key) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在读取---------");
        try {
            TimeUnit.MICROSECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成----------- : " + res);
        lock.readLock().unlock();
    }


}

public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}
