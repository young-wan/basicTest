package designPattern.ThreadTest;

/**
 * @author Administrator
 * @Author: Young
 * @Description: 线程测试
 * @Date: Created at 9/22 0022 17:18
 */
public class ThreadDemo {

    class Bank {
        private Integer account = 100;

        public Integer getAccount() {
            return account;
        }

        public void save(Integer money) {
            this.account += money;
        }

        public void save2(Integer money) {
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
            for (int i = 0; i < 30; i++) {
                bank.save2(10);
                System.out.println(i + " 当前账户余额为: " + bank.getAccount());
            }
        }
    }

    public void useThread() {
        Bank bank = new Bank();
        NewThread nt = new NewThread(bank);
        System.out.println("线程1------------");
        Thread thread1 = new Thread(nt);
        thread1.start();
        System.out.println("线程2------------");
        Thread thread2 = new Thread(nt);
        thread2.start();
    }


    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        td.useThread();

    }
}
