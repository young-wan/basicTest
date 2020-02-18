package designPattern.Singleton;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/20 9:54
 */
public class Singleton6 {
    private Singleton6() {

    }

    private static class Inner {

        private static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        return Inner.instance;
    }
}
