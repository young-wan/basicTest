package designPattern.ThreadTest;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/01/04 16:05
 */
public class SaleTicketTest implements Runnable {
    private static Integer total = 1000;
    private static Integer count = 1;


    @Override
    public void run() {
        synchronized (total) {
            while (total > 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了一张票, 票号为: " + count);
                count++;
                total--;
            }
        }
    }

    public static void main(String[] args) {
        SaleTicketTest stt = new SaleTicketTest();
//        Thread t1 = new Thread(stt, "售票厅" + 1 + "号");
//        Thread t2 = new Thread(stt, "售票厅" + 2 + "号");
//        Thread t3 = new Thread(stt, "售票厅" + 3 + "号");
//        Thread t4 = new Thread(stt, "售票厅" + 4 + "号");
//        Thread t5 = new Thread(stt, "售票厅" + 5 + "号");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        for (int i = 0; i < 5; i++) {
            new Thread(stt, "售票厅" + i + "号").start();
        }
    }
}
