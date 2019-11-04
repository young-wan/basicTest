package designPattern.cardPlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/07/12 11:43
 */
public class CardPlayTest {

    public static void main(String[] args) {
        List<CardPlay> cardList = new ArrayList<>();
        for (int i = 1; i <= 108; i++) {
            CardPlay cardPlay = new CardPlay();
            cardPlay.setName("card_" + i);
            cardPlay.setSort(i);
            if (i < TypeEnum.SS.getStart()) {
                cardPlay.setType(TypeEnum.SSS.getKey());
                cardPlay.setTypeName(TypeEnum.SSS.getName());
            } else if (i < TypeEnum.S.getStart()) {
                cardPlay.setType(TypeEnum.SS.getKey());
                cardPlay.setTypeName(TypeEnum.SS.getName());
            } else if (i < TypeEnum.A.getStart()) {
                cardPlay.setType(TypeEnum.S.getKey());
                cardPlay.setTypeName(TypeEnum.S.getName());
            } else {
                cardPlay.setType(TypeEnum.A.getKey());
                cardPlay.setTypeName(TypeEnum.A.getName());
            }
            cardList.add(cardPlay);
        }
//        System.out.println(cardList);
        getCard(cardList);
    }

    public static void getCard(List<CardPlay> cardList) {
        System.out.println("请输入抽卡次数: ");
        Scanner scanner = new Scanner(System.in);
        int getInt = scanner.nextInt();
        double ac = 0;
        double sc = 0;
        double ssc = 0;
        double sssc = 0;
        for (int i = 1; i <= getInt; i++) {
            System.out.println("--------开始抽卡:------第" + i + "次");
            double ran = Math.random();
            int getCount;
            if (ran <= TypeEnum.SSS.getRan()) {
                getCount = cardIndex(ran, TypeEnum.SSS.getTotal(), TypeEnum.SSS.getStart());
                sssc += 1;
            } else if (ran <= TypeEnum.SS.getRan() + TypeEnum.SSS.getRan()) {
                getCount = cardIndex(ran, TypeEnum.SS.getTotal(), TypeEnum.SS.getStart());
                ssc += 1;
            } else if (ran <= TypeEnum.S.getRan() + TypeEnum.SS.getRan() + TypeEnum.SSS.getRan()) {
                getCount = cardIndex(ran, TypeEnum.S.getTotal(), TypeEnum.S.getStart());
                sc += 1;
            } else {
                getCount = cardIndex(ran, TypeEnum.A.getTotal(), TypeEnum.A.getStart());
                ac += 1;
            }
            System.out.println(cardList.get(getCount).toString());
        }

        System.out.println("总共抽卡:" + getInt + "次,其中: \n"
                + "抽取到SSS卡: " + sssc + "次" + "概率为: " + (sssc / getInt * 100) + "%\n"
                + "抽取到SS卡: " + ssc + "次" + "概率为: " + (ssc / getInt * 100) + "%\n"
                + "抽取到S卡: " + sc + "次" + "概率为: " + (sc / getInt * 100) + "%\n"
                + "抽取到A卡: " + ac + "次" + "概率为: " + (ac / getInt * 100) + "%\n");

        System.out.println("系统设定的概率为: \n"
                + "抽取到SSS卡的概率为: 1%\n"
                + "抽取到SS卡的概率为: 10%\n"
                + "抽取到S卡的概率为: 20%\n"
                + "抽取到A卡的概率为: 69%\n");
    }

    private static Integer cardIndex(double ran, int total, int start) {
        int index = (int) ((ran * total) + start);
        return index;
    }

}
