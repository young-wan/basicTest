package design_pattern.$2_prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author young
 * @Date 2020/5/21 10:06
 * @Desc 原型管理器
 **/
interface Shape extends Cloneable {

    Shape clone();

    void countArea();
}

public class Circle implements Shape {
    private static final double PI = 3.14;

    @Override
    public Shape clone() {
        Circle c = null;
        try {
            c = (Circle) super.clone();
            System.out.println("拷贝圆形成功!");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void countArea() {
        System.out.println("这是圆形,请输入半径r: ");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        System.out.println("圆形的面积为: " + (PI * r * r) + "\n");
    }
}

class Square implements Shape {

    @Override
    public Shape clone() {
        Square s = null;
        try {
            System.out.println("拷贝正方形成功");
            s = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void countArea() {
        System.out.println("这是正方形,请输入边长r: ");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        System.out.println("正方形的面积为: " + (r * r) + "\n");
    }
}

class ProtoManager {
    private HashMap<String, Shape> map = new HashMap<>(4);

    public ProtoManager() {
        map.put("circle", new Circle());
        map.put("square", new Square());
    }

    public void addShape(String key, Shape shape) {
        map.put(key, shape);
    }

    public Shape getShape(String key) {
        return map.get(key);
    }
}

class ProtoTest {
    public static void main(String[] args) {
        ProtoManager pm = new ProtoManager();
        Shape shape1 = pm.getShape("circle");
        shape1.countArea();

        Shape cs = shape1.clone();
        cs.countArea();

        Circle circle = (Circle) shape1.clone();
        circle.countArea();

        Shape shape2 = pm.getShape("square");
        shape2.countArea();

        Square square = (Square) shape2.clone();
        square.countArea();
    }

}
