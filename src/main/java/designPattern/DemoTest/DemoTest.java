package designPattern.DemoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 8/28 0028 15:00
 */
public class DemoTest extends Thread {
    public void test() {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String s = scanner.next();
//            if (!s.equalsIgnoreCase("q")) {
//                System.out.println("print: " + s);
//            } else {
//                break;
//            }
//            System.out.println("print a word: ");
//        }

    }

    @Override
    public void run() {
        System.out.println("child run !");
    }

    public static void main(String[] args) {
        DemoTest dt = new DemoTest();
        dt.test();

        dt.run();

    }


}
