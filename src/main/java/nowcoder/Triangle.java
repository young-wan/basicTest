package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/18 9:36
 */
public class Triangle extends Shape {
    static {
        System.out.println("triangle static----");
    }
    public Triangle() {
        System.out.println("triangle construct");
    }

    @Override
    public void print() {
        System.out.println("this is a triangle");
    }
}
