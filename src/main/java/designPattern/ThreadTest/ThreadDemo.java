package designPattern.ThreadTest;

/**
 * @Author: Young
 * @Description: 线程测试
 * @Date: Created at 9/22 0022 17:18
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.run();
//        thread.stop();
        int i = 0;
        while (thread.isAlive() && i < 5){
            System.out.println("线程进行中..." + i);
            i++;
        }
    }
}
