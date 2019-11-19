package nowcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/12 16:09
 */
public class PriorityQueueDemo {
    private static Random random = new Random(47);

    public static void main(String[] args) {
//        Random random = new Random(47);
//        PriorityQueue<Integer> integers = new PriorityQueue<>();
//        for (int i = 0; i < 10; i++) {
//            integers.offer(random.nextInt(i + 10));
//        }
//        QueueDemo.printQ(integers);
//
//        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        integers = new PriorityQueue<>(ints);
//        QueueDemo.printQ(integers);
//
//        integers = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
//        QueueDemo.printQ(integers);
//
//        String string = "THIS IS A QUEUE DEMO";
//        List<String> strings = Arrays.asList(string.split(""));
//        PriorityQueue<String> characters = new PriorityQueue(strings);
//        QueueDemo.printQ(characters);

        List<String> list = new LinkedList<>();
        for (int k = 0; k < 13; k++) {
            String str = "";
            for (int i = 0; i < 5; i++) {
                char c = (char) getInt();
                str += c;
            }
            list.add(str);
        }
        list.add("BObI");
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
    }

    public static int getInt() {
        int i = random.nextInt(57) + 65;
        if (i > 90 && i < 97) {
            return getInt();
        }
        return i;
    }
}
