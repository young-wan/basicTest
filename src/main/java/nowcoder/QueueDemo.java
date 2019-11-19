package nowcoder;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/12 15:39
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (Objects.nonNull(queue.peek())) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);

    }
}
