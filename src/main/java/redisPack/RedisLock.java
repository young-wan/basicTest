package redisPack;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * @Author young
 * @Date 2020/7/22 10:08
 * @Desc
 **/
public class RedisLock {

    private static String key = "redis_lock_key";

    private static Long timeout = 5L;

    private static Long lockTime = 30000L;


    public static void main(String[] args) {
        oneJvm();
    }

    private static void oneJvm() {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                lock();
            }, String.valueOf(i)).start();
        }
    }

    private static void lock() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        if (jedis.setnx(key, "1") > 0) {
            jedis.expire(key, 5);
            System.out.println(Thread.currentThread().getName() + "抢到锁");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                jedis.del(key);
                System.out.println(Thread.currentThread().getName() + "释放锁");
                System.out.println("---------------------");
            }
        } else {
            lock();
        }
    }


}
