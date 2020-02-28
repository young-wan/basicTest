package resume_practice.DistributedLock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/27 9:58
 */
public class ZkLockImpl extends ZkLockTemplate {
    @Override
    public boolean checkClient() {
        try {
            zkClient.createEphemeral(path);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void clientWait() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                countDownLatch.countDown();
            }
        };
        zkClient.subscribeDataChanges(path, iZkDataListener);
        if (zkClient.exists(path)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path, iZkDataListener);
    }
}
