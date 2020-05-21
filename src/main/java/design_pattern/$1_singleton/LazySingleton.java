package design_pattern.$1_singleton;

/**
 * @Author young
 * @Date 2020/5/21 9:20
 * @Desc 懒汉式
 **/
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
