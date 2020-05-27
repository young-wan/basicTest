package design_pattern.$11_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author young
 * @Date 2020/5/27 16:04
 * @Desc 享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
 **/
public class FlyweightTest {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f01 = factory.getFlyweight("a");
        Flyweight f02 = factory.getFlyweight("a");
        Flyweight f03 = factory.getFlyweight("a");
        Flyweight f11 = factory.getFlyweight("b");
        Flyweight f12 = factory.getFlyweight("b");
//        f01.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
//        f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
//        f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
//        f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
//        f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));
        System.out.println("f01==f02" + f01.equals(f02));
        System.out.println("f01==f03" + f01.equals(f03));
        System.out.println("f11==f12" + f11.equals(f12));
        System.out.println("f01" + f01);
        System.out.println("f02" + f02);
        System.out.println("f03" + f03);
        System.out.println("f11" + f11);
        System.out.println("f12" + f12);

    }

}

//非享元角色
class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

//抽象享元角色
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}

//具体享元角色
class ConcreteFlyweight implements Flyweight {
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + outState.getInfo());
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (null != flyweight) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key, flyweight);
        }
        return flyweight;
    }
}