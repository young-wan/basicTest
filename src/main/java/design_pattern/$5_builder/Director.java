package design_pattern.$5_builder;

/**
 * @Author young
 * @Date 2020/5/21 17:56
 * @Desc 指挥者：调用建造者中的方法完成复杂对象的创建。
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}
