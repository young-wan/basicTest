package design_pattern.$5_builder;

/**
 * @Author young
 * @Date 2020/5/21 17:57
 * @Desc
 **/
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
