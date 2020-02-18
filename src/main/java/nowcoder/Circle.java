package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/18 9:35
 */
public class Circle extends Shape {
    static {
        System.out.println("circle static----");
    }

    public Circle() {
        System.out.println("circle construct");
    }

    public void pr() {
        System.out.println("circle  pr");
    }

    @Override
    public void print() {
        System.out.println("this is a circle");
    }

}
