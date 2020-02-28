package resume_practice.DistributedLock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/27 9:49
 */
public abstract class ZkLockTemplate implements ZkLock {

    public static final String ZK_URL = "191.168.111.114:2891";

    public static final int TIME_OUT = 45 * 1000;

    protected String path = "zk01";

    protected CountDownLatch countDownLatch = null;

    protected ZkClient zkClient = new ZkClient(ZK_URL, TIME_OUT);

    @Override
    public void zkLock() {
        if (checkClient()) {
            System.out.println(Thread.currentThread().getName() + "\t 占用锁成功");
        } else {
            clientWait();
            zkLock();
        }
    }


    public abstract boolean checkClient();

    public abstract void clientWait();

    @Override
    public void zkUnlock() {
        if (zkClient != null) {
            zkClient.close();
            System.out.println(Thread.currentThread().getName() + "\t 释放锁成功");
        }
        System.out.println();
        System.out.println();
    }
}
