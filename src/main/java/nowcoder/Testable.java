package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/25 10:38
 */
public class Testable implements Runnable {

    private int count;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (count < 10){
            try {
                Thread.sleep(1000);
                System.out.println(count++);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Testable());
        t.start();
    }
}
