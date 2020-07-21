package JUCPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 11:00
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = synchronizedList();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
    }

    /**
     * 普通list
     *
     * @return
     */
    private static List<String> notSafeList() {
        return new ArrayList<>();
    }

    /**
     * vertor
     *
     * @return
     */
    private static List<String> vectorList() {
        return new Vector<>();
    }

    /**
     * copyonwrite
     *
     * @return
     */
    private static List<String> copyOnWriteList() {
        return new CopyOnWriteArrayList<>();
    }

    /**
     * synchronizedList
     *
     * @return
     */
    private static List<String> synchronizedList() {
        return Collections.synchronizedList(notSafeList());
    }

}
