package designPattern.ThreadTest;

/**
 * @Author: Young
 * @Description: 线程测试
 * @Date: Created at 9/22 0022 17:18
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("current thread : " + thread);
        System.out.println("current thread : " + thread.getName());
        System.out.println("current thread : " + thread.currentThread());
        for (int i = 0; i < 5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
