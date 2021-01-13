package redisPack;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * @Author young
 * @Date 2020/6/1 19:17
 * @Desc
 **/
public class RedisTest {
    public static void main(String[] args) {
//        stringDemo();
//        hashDemo();
//        listDemo();
//        setDemo();
        zsetDemo();
    }

    public static void stringDemo() {
        Jedis jedis = RedisUtils.getInstance();
        jedis.set("k1", "1");
        System.out.println(jedis.get("k1"));
        System.out.println("incr-----");
        jedis.incr("k1");
        System.out.println(jedis.get("k1"));
        System.out.println("decr----");
        jedis.decrBy("k1", 3);
        System.out.println(jedis.get("k1"));
    }

    public static void hashDemo() {
        Jedis jedis = RedisUtils.getInstance();
        jedis.hset("hash", "h1", "v1");
        jedis.hset("hash", "h2", "2");
        jedis.hset("hash", "h3", "3");
        System.out.println(jedis.hgetAll("hash"));
        System.out.println(jedis.hget("hash", "h1"));
        jedis.hincrBy("hash", "h2", 10);
        System.out.println(jedis.hget("hash", "h2"));

    }

    public static void listDemo() {
        Jedis jedis = RedisUtils.getInstance();
        System.out.println(jedis.llen("list"));
        for (int i = 0; i < jedis.llen("list"); i++) {
            jedis.lpop("list");
        }
        jedis.lpush("list", new String[]{"1", "2", "3"});
        jedis.lset("list", 0, "10");
//        System.out.println(jedis.lpop("list"));
        System.out.println(jedis.llen("list"));
        System.out.println(jedis.lindex("list", 2));
        System.out.println(jedis.lrange("list", 0, 2));
        System.out.println(jedis.lrange("list", 0, -1));

    }

    public static void setDemo() {
        Jedis jedis = RedisUtils.getInstance();
        jedis.sadd("set", "1");
        jedis.sadd("set3", "刘备", "关羽", "张飞", "赵云", "诸葛亮");
        System.out.println(jedis.smembers("set3"));
        System.out.println(jedis.spop("set3"));
        System.out.println(jedis.scard("set3"));
    }

    public static void zsetDemo() {
        Jedis jedis = RedisUtils.getInstance();
        jedis.zadd("zset", 1.0, "z1");
        jedis.zadd("zset", new HashMap<String, Double>() {{
            put("a1", 1.0);
            put("a2", 2.0);
            put("a3", 3.0);
        }});
        System.out.println(jedis.zcard("zset"));
        System.out.println(jedis.zrange("zset", 0, -1));
    }
}
