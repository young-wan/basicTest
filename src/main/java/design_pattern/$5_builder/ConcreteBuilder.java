package design_pattern.$5_builder;

/**
 * @Author young
 * @Date 2020/5/21 17:54
 * @Desc 具体建造者：实现了抽象建造者接口。
 **/
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("build A");
        System.out.println("build A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("build B");
        System.out.println("build B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("build C");
        System.out.println("build C");
    }
}
