package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/06 11:16
 */
public class TwoTuple<A, B> {
    public final A first;

    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("1a", 1);
        System.out.println(twoTuple.toString());
    }
}
