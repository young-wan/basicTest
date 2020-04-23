package CacehPack;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Young
 * @create 2020-04-16 17:08
 * @desc exam
 * {@link}
 **/
public class CacheDemo {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        // 创建缓存管理者
        CacheManager cacheManager = new CacheManager();

        // 从ehcache.xml中获取name为demoCache的缓存创建Cache对象
        Cache cache = cacheManager.getCache("demoCache");

        // 创建一个key
        String key = "keyDemo";

        // 创建一个待放入cache中的element对象
//        Element element;

        // 将element放入cache中
//        cache.put(element);
//        if (Objects.nonNull(cache.get(key))) {
//            System.out.println("请勿重复提交!");
//        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(integer.get());
                if (Objects.isNull(cache.get(key)) && integer.compareAndSet(integer.get(), integer.get() +1)) {
                    Element element = new Element(key, Thread.currentThread().getName());
                    if (Objects.isNull(cache.get(key))){
                        cache.put(element);
                        System.out.println(Thread.currentThread().getName() + "提交成功");
                    }
                }
            }, "thread-" + i).start();
        }

        // 从cache中获取对应key的element对象
        Element getEle = cache.get(key);

        System.out.println("get element---" + getEle.toString());
        System.out.println("总提交数: " + integer);
    }

}
