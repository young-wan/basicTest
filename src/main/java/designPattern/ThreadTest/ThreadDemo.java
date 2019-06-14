package designPattern.ThreadTest;

/**
 * @author Administrator
 * @Author: Young
 * @Description: 线程测试
 * @Date: Created at 9/22 0022 17:18
 */
public class ThreadDemo {

    class Bank {
        private int account = 100;

        public int getAccount() {
            return this.account;
        }

        public synchronized void saveMeth(int money) {
            this.account += money;
        }

        public void saveBlock(int money) {
            synchronized (this) {
                this.account += money;
            }
        }
    }


    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                bank.saveMeth(10);
                bank.saveBlock(10);
                System.out.println(i + "账户余额为: " + bank.getAccount());
            }
        }
    }

    public void useThread() {
        Bank bank = new Bank();
        NewThread nt = new NewThread(bank);
        System.out.println("线程1-----------");
        Thread thread1 = new Thread(nt);
        thread1.start();
        ;

        System.out.println("线程2-----------");
        Thread thread2 = new Thread(nt);
        thread2.start();
    }

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        td.useThread();
    }
}
