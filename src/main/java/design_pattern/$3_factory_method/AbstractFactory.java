package design_pattern.$3_factory_method;

/**
 * @Author young
 * @Date 2020/5/21 10:49
 * @Desc 工厂方法（Factory Method）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。
 **/
public class AbstractFactory {
    public static void main(String[] args) {
        AbsFactory af1 = new Pro1Fact();
        Product p1 = af1.newProduct();
        p1.show();

        AbsFactory af2 = new Pro2Fact();
        Product p2 = af2.newProduct();
        p2.show();
    }
}

interface Product {
    void show();
}

class Product1 implements Product {

    @Override
    public void show() {
        System.out.println("产品1----------");
    }
}

class Product2 implements Product {

    @Override
    public void show() {
        System.out.println("产品2--------------");
    }
}

interface AbsFactory {
    Product newProduct();
}

class Pro1Fact implements AbsFactory {

    @Override
    public Product newProduct() {
        System.out.println("工厂1生成---->产品1");
        return new Product1();
    }
}

class Pro2Fact implements AbsFactory {

    @Override
    public Product newProduct() {
        System.out.println("工厂2生成---->产品2");
        return new Product2();
    }
}
