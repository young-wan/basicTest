package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/18 9:34
 */
public class Shape {
    static {
        System.out.println("shape static ============");
    }
    private String name;

    private String type;

    public Shape() {
        System.out.println("shape construct-----------");
    }
    private void pr(){
        System.out.println("shape---pr");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void print() {
        System.out.println("this is a shape");
    }

    public void print(Shape shape) {
        System.out.println(shape.getClass().getName());
        shape.print();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.print(circle);
        circle.pr();
        Shape triangle = new Triangle();
        triangle.print(triangle);
    }
}
