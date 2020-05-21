package design_pattern.$5_builder;

/**
 * @Author young
 * @Date 2020/5/21 17:52
 * @Desc 抽象建造者：包含创建产品各个子部件的抽象方法。
 **/
public abstract class Builder {
    // 创建产品对象
    protected Product product = new Product();

    // 返回产品对象
    public Product getProduct() {
        return product;
    }

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();
}
