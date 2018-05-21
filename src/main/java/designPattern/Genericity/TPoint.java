package designPattern.Genericity;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/22 0022 9:48
 */
public class TPoint<T1, T2> {
    T1 x;
    T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }


    public static void main(String[] args) {
        TPoint<Integer, Integer> tPoint = new TPoint<Integer, Integer>();

        tPoint.setX(10);
        tPoint.setY(20);

        int a = tPoint.getX();
        int b = tPoint.getY();
        System.out.println("a is : " + a + " and b is : " + b);

        TPoint<Integer, String> tp2 = new TPoint<Integer, String>();
        tp2.setX(30);
        tp2.setY("go 4 it");

        int m = tp2.getX();
        String n = tp2.getY();
        System.out.println("This point is：" + m + ", " + n);
    }
}
