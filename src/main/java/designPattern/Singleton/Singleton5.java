package designPattern.Singleton;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/20 9:53
 */
public class Singleton5 {
    private Singleton5() {
        System.out.println(Thread.currentThread().getName() + "\t 创建线程");

    }

    private volatile  static Singleton5 instance;

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    instance = new Singleton5();
                }
                return instance;
            }
        }
        return instance;
    }
}
