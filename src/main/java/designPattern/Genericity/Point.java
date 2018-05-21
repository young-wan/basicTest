package designPattern.Genericity;

/**
 * @Author: Young
 * @Description: 泛型测试
 * @Date: Created at 9/22 0022 9:44
 */
public class Point {
    Object x = 0;
    Object y = 0;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Point point = new Point();

        point.setX(10);
        point.setY(20);

        int a = (Integer)point.getX();
        int b= (Integer)point.getY();

        System.out.println("a is : " + a + " and b is : " + b);

        point.setX(25.4);  // double -> Integer -> Object
        point.setY("东京180度");
        double m = (Double)point.getX();  // 必须向下转型
        double n = (Double)point.getY();  // 运行期间抛出异常
        System.out.println("This point is：" + m + ", " + n);
    }
}
