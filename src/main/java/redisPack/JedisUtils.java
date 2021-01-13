package redisPack;

import redis.clients.jedis.JedisPool;

/**
 * @Author young
 * @Date 2020/7/22 10:09
 * @Desc
 **/
public class JedisUtils {
    private static JedisPool jedisPool;

    public static void main(String[] args) {
        jedisPool.getResource();
    }
}
