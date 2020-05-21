package design_pattern.$1_singleton;

/**
 * @Author young
 * @Date 2020/5/21 9:22
 * @Desc 饿汉式
 **/
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
