package designPattern.ColletionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 10/25 0025 11:53
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>() {{
            add(0, "a");
            add(1, "b");
            add(2, "c");
            add(3, "d");
        }};
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println("next: " + iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.println("next2: " + iterator.next());
        }

        for (String str : names) {
            System.out.println("for: " + str);
        }
        names.forEach(System.out::print);


        List<String> list = new ArrayList<>();
        list.add("Oracle");
        list.add("SQL");
        list.add("CSS");
        list.add("XML");
        System.out.println("List: " + list);
        // Get the list iterator
        ListIterator<String> iteratorL = list.listIterator();
        while (iteratorL.hasNext()) {
            int index = iteratorL.nextIndex();
            String element = iteratorL.next();
            System.out.println("Index=" + index + ", Element=" + element);
        }
        // Reuse the iterator to iterate from the end to the beginning
        while (iteratorL.hasPrevious()) {
            int index = iteratorL.previousIndex();
            String element = iteratorL.previous();
            System.out.println("Index=" + index + ",  Element=" + element);
        }
        Collections.sort(list);
        System.out.println("sort: " + list);
        Collections.rotate(list, 3);
        System.out.println("rotate" + list);



        List<String> siL = Collections.singletonList("a");
        siL.add("bb");
        System.out.println(siL);

//        iterator.forEachRemaining(System.out::println);
    }
}
