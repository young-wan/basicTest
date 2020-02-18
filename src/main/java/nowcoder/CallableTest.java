package nowcoder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/12/03 11:08
 */
public class CallableTest implements Callable<String> {
    private String str;

    public CallableTest(String str) {
        this.str = str;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return this.str + "append something and return it !";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new CallableTest("my callable test ");
        FutureTask<String> task = new FutureTask(callable);
        new Thread(task).start();
        synchronized (task) {
            System.out.println("synch  task----");
        }
        String result = task.get();
        System.out.println(task.isDone());
        System.out.println(result);
    }
}
