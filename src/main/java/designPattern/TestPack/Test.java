package designPattern.TestPack;

import designPattern.MathCountTest.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 6/11 0011 10:15
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(-1 % 10);
//
//        int count = 2222;
//
//        int[] cards = randCreate(count);
//        QuickSort sort = new QuickSort();
//        sort.sort(cards, 0, count - 1);
//        System.out.println(cards[cards.length / 2]);
//
//        int number = 4324;
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < 32; i++) {
//            sb.append(number & 1);
//            number = number >>> 1;
//        }
//        String a = sb.toString();
//
//        System.out.println(a.charAt(0));

        for (int i = 0; i < 20; i++){
            System.out.println(randTo10());
        }

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
        while (number > 45){
            number = randNumber(7) * randNumber(7);
        }
        return number % 9 + 1;
    }


}
