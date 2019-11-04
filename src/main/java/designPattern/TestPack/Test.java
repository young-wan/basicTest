package designPattern.TestPack;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 6/11 0011 10:15
 */
public class Test {
    private int count;

    private String name;

    public static void main(String[] args) {
        int c = 7;
        String n = "name";
        foo(c);
        foo(n);
        StringBuffer sb = new StringBuffer("aaa");
        foo(sb);
        StringBuffer sb2 = new StringBuffer("aaa");
        foo2(sb2);
        System.out.println(c);
        System.out.println(n);
        System.out.println(sb);
        System.out.println(sb2);
    }

    private static void foo(int i) {
        i = 100;
    }

    private static void foo(String s) {
        s = "hello";
    }

    private static void foo(StringBuffer sb){
        sb.append("1111");
    }
    private static void foo2(StringBuffer sb){
        sb = new StringBuffer("333");
    }

    /**
     * 自动生成随机数组
     *
     * @param count
     * @return
     */
    private static int[] randCreate(Integer count) {
        int[] cards = new int[count];
        List<Integer> usedCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Integer cardNumber = Math.toIntExact((long) (Math.random() * count)) + 1;
            if (usedCards.contains(cardNumber)) {
                i--;
                continue;
            }
            usedCards.add(cardNumber);
            cards[i] = cardNumber;
        }
        return cards;
    }

    private static Integer randNumber(Integer count) {
        Integer number;
        number = (int) (Math.random() * ((count - 1 + 1) + 1));
        return number;
    }

    private static Integer randTo10() {
        int number = 49;
        while (number > 45) {
            number = randNumber(7) * randNumber(7);
        }
        return number % 9 + 1;
    }


}
