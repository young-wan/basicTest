package nowcoder;

import java.util.LinkedList;
import java.util.List;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/18 15:20
 */
public class StringImute {
    @Override
    public String toString() {
        return "StringImute{}" + super.toString() + "\n";
    }

    public static void main(String[] args) {

        List<StringImute> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new StringImute());
        }
        System.out.println(list);

    }

}
