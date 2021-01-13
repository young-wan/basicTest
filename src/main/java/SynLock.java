import net.sf.ehcache.concurrent.LockType;
import net.sf.ehcache.concurrent.Sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author young
 * @Date 2020/12/16 13:32
 * @Desc
 **/
public class SynLock extends AbstractQueuedSynchronizer {
    private SynLock synLock;

    public SynLock() {
        synLock = new SynLock();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        synLock.tryAcquire(arg);
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
