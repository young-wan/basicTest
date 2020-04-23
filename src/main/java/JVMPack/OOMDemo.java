package JVMPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/21 16:23
 */
public class OOMDemo {
    byte[] a = new byte[1024*5];

    private static void stackOverFlow() {
        stackOverFlow();
    }


    private static void outOfMemory() {
        String str = "out";
        while (true) {
            str += str + new Random().nextInt(10000000) + new Random().nextInt(100000);
            str.intern();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMDemo> list = Collections.synchronizedList(new ArrayList<>(1000));
        while (true) {
            list.add(new OOMDemo());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }





    }
}
