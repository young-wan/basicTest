package resume_practice.JVMPack;

import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/21 16:23
 */
public class OOMDemo {

    private static void stackOverFlow() {
        stackOverFlow();
    }


    private static void outOfMemory(){
        String str = "out";
        while (true){
            str += str + new Random().nextInt(10000000) + new Random().nextInt(100000);
            str.intern();
        }
    }

    public static void main(String[] args) {
        outOfMemory();
    }
}
