package design_pattern.$1_singleton;

/**
 * @Author young
 * @Date 2020/5/21 9:24
 * @Desc 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
 **/
public class SingletonDemo {
    public static void main(String[] args) {
        President p1 = President.getInstance();
        p1.showName();
        President p2 = President.getInstance();
        p2.showName();
        if (p1 == p2) {
            System.out.println("是同一人");
        } else {
            System.out.println("不是同一人");
        }
        // 多线程下的异常
//        for (int i = 0; i < 100; i++){
//            new Thread(()->{
//                President.getInstance();
//            }).start();
//        }
    }

}

class President {
    private static President instance;

    private President() {
        System.out.println("产生一位总统");
    }

    public static President getInstance() {
        if (instance == null) {
            instance = new President();
        } else {
            System.out.println("已经存在一个president了!");
        }
        return instance;
    }

    public void showName() {
        System.out.println("当前总统: trump");
    }
}
