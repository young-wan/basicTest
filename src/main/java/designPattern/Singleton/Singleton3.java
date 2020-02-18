package designPattern.Singleton;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/20 9:49
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }

}
