package JUCPack;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author young
 * @Date 2020/7/30 14:59
 * @Desc
 **/
public class ComputableFutureDemo {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            4,
            6,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("come in completableFuture method");
        List<Model> list = new LinkedList<>();

        CompletableFuture<Model> normalFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("put first model ===");
            Model model = new Model(1, 1);
            list.add(model);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return model;
        }, THREAD_POOL_EXECUTOR);


        CompletableFuture<Void> future2 = normalFuture.thenAcceptAsync(res -> {
            System.out.println("future2 res : " + res.toString());
            Model model = new Model(2, 2);
            list.add(model);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, THREAD_POOL_EXECUTOR);


        CompletableFuture.allOf(future2).get();
        System.out.println("get all res==========");
        THREAD_POOL_EXECUTOR.shutdown();
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}

class Model {
    private int age;

    private int num;


    public Model(int age, int num) {
        this.age = age;
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Model{" +
                "age=" + age +
                ", num=" + num +
                '}';
    }
}
