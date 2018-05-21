package designPattern.VectorTest;

import java.io.IOException;
import java.util.Vector;

/**
 * @Author: Young
 * @Description: 向量测试
 * @Date: Created at 9/22 0022 16:13
 */
public class VectorTest {

    public static void main(String[] args) throws IOException {
//        Vector vector = new Vector(0, 2);
//        vector.add("sdfsdf");
//        System.out.println(vector.capacity());
//        vector.trimToSize();
//        System.out.println(vector.capacity());
        doWhileTest();
    }

    public void vectorDemo1(){
        Vector vector = new Vector();
    }

    public static void numberTest(){
            int a = 1;
            int b = 2;
            int c = a | b;
            int d = a & b;
            int e = a ^ b;
            int f = (~a & b) | (a & ~b);
            int g = ~a & 0x0f;

            System.out.println(" a = " + a);
            System.out.println(" b = " + b);
            System.out.println(" a|b = " + c);
            System.out.println(" a&b = " + d);
            System.out.println(" a^b = " + e);
            System.out.println("~a&b|a&~b = " + f);
            System.out.println(" ~a = " + g);

    }

    public static void doWhileTest() throws IOException {
        char choice;
        do {
            System.out.println("Help on:");
            System.out.println(" 1. A");
            System.out.println(" 2. B");
            System.out.println(" 3. C");
            System.out.println(" 4. D");
            System.out.println(" 5. E");
            System.out.println("Choose one:");
            choice = (char) System.in.read();
        } while (choice < '1' || choice > '5');
        System.out.println("\n");
        switch (choice) {
            case '1':
                System.out.println("A");
                break;
            case '2':
                System.out.println("B");
                break;
            case '3':
                System.out.println("C");
                break;
            case '4':
                System.out.println("D");
                break;
            case '5':
                System.out.println("E");
                break;
        }
    }
}
