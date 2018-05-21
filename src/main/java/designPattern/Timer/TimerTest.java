package designPattern.Timer;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Author: Young
 * @Description: 定时器
 * @Date: Created at 11/17 0017 16:20
 */
public class TimerTest {
    public int count;

    public TimerTest(int count){
        this.count = count;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer定时器" + new Date());
            }
        }, 2000, 1000);

    }

}