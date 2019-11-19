package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/18 9:34
 */
public class Shape {

    private int i;
    private Integer k;

    public Shape() {

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    private String name;

    private String type;


    private void pr() {
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

    }
}
