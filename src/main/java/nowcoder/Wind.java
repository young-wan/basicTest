package nowcoder;


/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/04 10:34
 */

public class Wind {

    private final int x;

    public Wind() {
        x = 1;
    }

    public Wind(int i) {
        x = i;
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        System.out.println(wind.x);

        Wind wind1 = new Wind(10);
        System.out.println(wind1.x);

        Wind wind2 = new Wind(20);
        System.out.println(wind2.x);
    }
}
