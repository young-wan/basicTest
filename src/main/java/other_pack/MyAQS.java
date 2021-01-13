package other_pack;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author young
 * @Date 2020/7/16 19:17
 * @Desc
 **/
public class MyAQS extends AbstractQueuedSynchronizer {
    protected MyAQS() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

    public static void main(String[] args) {
        MyAQS myAQS = new MyAQS();
        myAQS.getState();
        myAQS.setState(1);
    }
}
