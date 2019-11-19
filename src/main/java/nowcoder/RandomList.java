package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/07 15:04
 */
public class RandomList<T> {
    Random random = new Random(47);
    private List<T> list = new ArrayList<>();

    private void add(T item) {
        list.add(item);
    }

    private T select() {
        return list.get(random.nextInt(10));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for (String str : "this is a simple random list test for java project".split(" ")) {
            randomList.add(str);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(randomList.select());
        }
    }
}
