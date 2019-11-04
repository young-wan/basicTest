package nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/30 14:31
 */

public class House {
    protected Door door;
    Door door1 = new Door(2);

    private Window window;
    Window window1 = new Window(1);

    House() {
        Window window2 = new Window(33);
        System.out.println("House");
    }

    static void printArray(Object[] arr) {
        for (Object obj : arr) {
            System.out.println(obj);
        }
    }

    static void printVir(Object... args) {
        for (Object obj : args) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        Set<Integer> set2 = new LinkedHashSet<>();
        HashSet<String> set1 = new HashSet();
        List<Integer> list = new ArrayList<>();
        list.contains(1);
        Set<String> set = new HashSet<>();
        set.contains("1");
        Map map = new HashMap(2);
        map.containsKey("1");
        System.out.println("window: " + set2);
        System.out.println("this is a simple test example");
    }
}

class Door {
    Door(int door) {
        System.out.println("Door size : " + door);
    }
}

class Window extends House {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}
