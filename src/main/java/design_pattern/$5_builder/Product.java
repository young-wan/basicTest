package design_pattern.$5_builder;

/**
 * @Author young
 * @Date 2020/5/21 17:51
 * @Desc 产品角色：包含多个组成部件的复杂对象。
 **/
public class Product {
    private String partA;

    private String partB;

    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("product finish");
    }
}
