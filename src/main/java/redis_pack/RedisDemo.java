package redis_pack;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author young
 * @Date 2021/2/1 9:17
 * @Desc
 **/
public class RedisDemo {
    private static JedisPool jedisPool = RedisUtils.getJedisPool();

    public static void main(String[] args) {
        Jedis jedis = jedisPool.getResource();
        Long k3 = jedis.setnx("", "k3");
        System.out.println(k3);
    }
}
