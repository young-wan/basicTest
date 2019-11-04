package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/29 16:04
 */
public class Flower {
    int count = 0;
    String str = "initial value";

    Flower(int c) {
        count = c;
        System.out.println("int param");
    }

    Flower(String s) {
        str = s;
    }

    Flower(int c, String s) {
        this(c);
        this.str = s;
        System.out.println("two param");
    }

    Flower() {
        this(10, "hi");
        System.out.println("no const");
    }

    void printCount() {
        System.out.println(this.count + "-------" + this.str);
        System.out.println(count + "-------" + str);
    }

    public static void main(String[] args) {
        Flower f = new Flower();
        f.printCount();
    }
}
