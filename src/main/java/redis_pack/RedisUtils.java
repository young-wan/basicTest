package redis_pack;

import redis.clients.jedis.JedisPool;

/**
 * @Author young
 * @Date 2021/2/1 9:15
 * @Desc
 **/
public class RedisUtils {
    private static final String JEDIS_URL = "127.0.0.1";
    private static final Integer JEDIS_PORT = 6379;

    private static JedisPool jedisPool;

    private RedisUtils() {

    }

    public static JedisPool getJedisPool() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(JEDIS_URL, JEDIS_PORT);
        }
        return jedisPool;
    }
}
