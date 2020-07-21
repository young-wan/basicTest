package redisPack;

import redis.clients.jedis.Jedis;

/**
 * @author Young
 * @create 2020-04-18 14:48
 * @desc exam
 * {@link}
 **/
public class RedisUtils {

    private static Jedis instance;

    public RedisUtils() {
    }

    public static Jedis getInstance() {
        if (null == instance){
            instance = new Jedis("localhost", 6379);
        }
        return instance;
    }
}
