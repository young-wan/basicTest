package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/18 11:11
 */
public class DataOnly {
    int i;
    double d;
    float f;
    Integer integer;

    @Override
    public String toString() {
        return "DataOnly{" +
                "i=" + i +
                ", d=" + d +
                ", f=" + f +
                ", integer=" + integer +
                '}';
    }

    public static void main(String[] args) {
//        int i = 100;
////        meth1(i);
////        System.out.println(i);
//        meth2(i);
//        System.out.println(i);

        Integer x = 100;
        meth2(x);
        System.out.println(x);
    }

    public static int meth1(Integer i){
        i = 1;
        return i;
    }

    public static void meth2(Integer i){
        i = new Integer(2);
        Window window = new Window(2);
    }
}


