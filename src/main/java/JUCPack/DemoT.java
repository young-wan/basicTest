package JUCPack;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author young
 * @Date 2020/7/6 11:20
 * @Desc
 **/
public class DemoT {

    public static void main(String[] args) {
//        Object obj = new Object();
////        new Thread(new NumberModel(obj)).start();
////        new Thread(new CharModel(obj)).start();
//
//        new Thread(new PrintModel(obj, 1)).start();
//        new Thread(new PrintModel(obj, 2)).start();
//        new Thread(new PrintModel(obj, 3)).start();
        Map map = new HashMap();
        System.out.println(map.put("k1", "v1"));
        System.out.println(map.put("k2", "v2"));
    }


}

class NumberModel implements Runnable {
    private Object obj;

    public NumberModel(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 1; i < 53; i++) {
                if (i % 2 == 1) {
                    System.out.print(" ");
                }
                System.out.print(i);
                if (i % 2 == 0) {
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class CharModel implements Runnable {
    private Object obj;

    public CharModel(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.print(i);
                obj.notifyAll();
                if (i < 'Z') {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


class PrintModel implements Runnable {
    private static volatile Integer printNum = 0;

    private Object obj;
    private int threadId;

    public PrintModel(Object obj, int threadId) {
        this.obj = obj;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (printNum < 75) {
            synchronized (obj) {
                if (printNum / 5 % 3 + 1 == threadId) {
                    System.out.println("thread if " + threadId);
                    for (int i = 0; i < 5; i++) {
                        ++printNum;
//                        System.out.println("thread " + threadId + ": " + (++printNum));
                    }
                    obj.notifyAll();
                } else {
                    try {
                        System.out.println("thread else " + threadId);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}