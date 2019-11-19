package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/11 14:15
 */
public class AppleAndOrange {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Set<String> set = new LinkedHashSet<>();
        ArrayList<Apple> apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add("1");
            set.add("1");
        }
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("list " + i + ": " + list.get(i));
        }
        String[] strings = new String[]{"1", "2", "3"};
        List<String> ll = Arrays.asList(strings);
        ll.add("2");
    }
}

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {

}
