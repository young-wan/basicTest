package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/06 11:05
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<String> holder3 = new Holder3("String");
        String str = holder3.getA();
        Holder3<Integer> holder31 = new Holder3<>(1);
        Integer integer = holder31.getA();
        System.out.println(str);
        System.out.println(integer);
        Holder3<Shape> holder32 = new Holder3<>(new Circle());
        Shape shape =  holder32.getA();
        Circle circle = (Circle) holder32.getA();
        System.out.println(shape);
        System.out.println(circle);
    }
}
