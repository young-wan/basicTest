package resume_practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/19 10:00
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        offerPullDelay();


    }

    private static void offerPullDelay() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        try {
            System.out.println(blockingQueue.offer("a", 3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("b", 3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("c", 3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("d", 3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void putTake() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        try {
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
            System.out.println("==============");
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void offerPoll() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void addRemove() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
    }

}
