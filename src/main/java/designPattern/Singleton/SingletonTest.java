package designPattern.Singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/20 9:47
 */
public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            new Thread(() -> {
                Singleton5.getInstance();
            }, String.valueOf(i)).start();
        }
    }

    public static Singleton test1() {
        Singleton singleton = Singleton.INSTANCE;
        return singleton;
    }

    public static Singleton2 test2() {
        Singleton2 singleton2 = Singleton2.INSTANCE;
        return singleton2;
    }

    public static Singleton3 test3() {
        Singleton3 singleton3 = Singleton3.INSTANCE;
        return singleton3;
    }

    public static void test6() throws ExecutionException, InterruptedException {
        Callable<Singleton6> call = () -> Singleton6.getInstance();

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Singleton6> f1 = es.submit(call);
        Future<Singleton6> f2 = es.submit(call);

        Singleton6 s1 = f1.get();
        Singleton6 s2 = f2.get();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

        es.shutdown();
    }
}
