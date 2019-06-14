package designPattern.ColletionsDemo;

import designPattern.ClassDemo.MyClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 10/25 0025 11:54
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("HTML");
        s1.add("CSS");
        s1.add("XML");

        Set<String> s2 = new HashSet<>();
        s2.add("Java");
        s2.add("Javascript");
        s2.add("CSS");

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        performUnion(s1, s2);
        performIntersection(s1, s2);
        performDifference(s1, s2);
        testForSubset(s1, s2);

        SortedSet<String> names = new TreeSet<>();
        names.add("HTML");
        names.add("Java");
        names.add("SQL");
        names.add("CSS");
        System.out.println("Sorted Set: " + names);
        System.out.println("First: " + names.first());
        System.out.println("Last: " + names.last());

        SortedSet<String> ssBeforeCSS = names.headSet("CSS");
        System.out.println(ssBeforeCSS);

        SortedSet<String> ssBetwenCSSAndHTML = names.subSet("CSS", "HTML");
        System.out.println(ssBetwenCSSAndHTML);

        SortedSet<String> ssBetwenCSSAndHTML2 = names.subSet("CSS", "HTML");
        System.out.println(ssBetwenCSSAndHTML2);

        SortedSet<String> ssCSSAndAfter = names.tailSet("CSS");
        System.out.println(ssCSSAndAfter);
        comparing(MyClass::getName);

        SortedSet<String> strSet = new TreeSet<>(
                Comparator.nullsFirst(comparing(String::length))
        );
        strSet.add("XML");
        strSet.add("CSS");
        strSet.add("HTML");
        strSet.add(null);
        strSet.forEach(System.out::println);


    }

    public static void performUnion(Set<String> s1, Set<String> s2) {
        Set<String> s1Unions2 = new HashSet<>(s1);
        s1Unions2.addAll(s2);
        System.out.println("s1 union  s2: " + s1Unions2);
    }

    public static void performIntersection(Set<String> s1, Set<String> s2) {
        Set<String> s1Intersections2 = new HashSet<>(s1);
        s1Intersections2.retainAll(s2);
        System.out.println("s1 intersection  s2: " + s1Intersections2);
    }

    public static void performDifference(Set<String> s1, Set<String> s2) {
        Set<String> s1Differences2 = new HashSet<>(s1);
        s1Differences2.removeAll(s2);

        Set<String> s2Differences1 = new HashSet<>(s2);
        s2Differences1.removeAll(s1);

        System.out.println("s1 difference s2: " + s1Differences2);
        System.out.println("s2 difference s1: " + s2Differences1);
    }

    public static void testForSubset(Set<String> s1, Set<String> s2) {
        System.out.println("s2 is  subset s1: " + s1.containsAll(s2));
        System.out.println("s1 is  subset s2: " + s2.containsAll(s1));
    }
}
