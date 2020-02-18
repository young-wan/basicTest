package designPattern.Singleton;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/20 9:52
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
        System.out.println(Thread.currentThread().getName() + "\t 创建线程");
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }

}
