package redisPack;

import redis.clients.jedis.Jedis;

/**
 * @Author young
 * @Date 2020/6/1 19:17
 * @Desc
 **/
public class RedisTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
//                for (int j = 0; j < 10; j++) {
//                    secKill();
//                }
                secKill();
            }).start();
        }
    }

    public static void secKill() {
        Jedis jedis = RedisUtils.getInstance();
        String key = "redisKey";
        if (jedis.setnx(key, "1") > 0) {
            System.out.println(jedis.get("amount"));
            jedis.decr("amount");
        }
        jedis.del(key);
    }
}
