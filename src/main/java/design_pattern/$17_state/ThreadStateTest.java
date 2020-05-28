package design_pattern.$17_state;

/**
 * @Author young
 * @Date 2020/5/28 18:47
 * @Desc
 **/
public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }

}

class ThreadContext {
    private ThreadState threadState;

    public ThreadContext() {
        this.threadState = new New();
    }

    public ThreadState getThreadState() {
        return threadState;
    }

    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
    }

    public ThreadState getState() {
        return threadState;
    }

    public void start() {
        ((New) threadState).start(this);
    }

    public void getCPU() {
        ((Runnable) threadState).getCPU(this);
    }

    public void suspend() {
        ((Running) threadState).suspend(this);
    }

    public void stop() {
        ((Running) threadState).stop(this);
    }

    public void resume() {
        ((Blocked) threadState).resume(this);
    }
}

abstract class ThreadState {
    protected String stateName;
}

class New extends ThreadState {
    public New() {
        stateName = "新建状态";
    }

    public void start(ThreadContext context) {
        if (stateName.equals("新建状态")) {
            context.setThreadState(new Runnable());
        }
    }
}

class Runnable extends ThreadState {
    public Runnable() {
        stateName = "就绪状态";
        System.out.println("当前线程处于：就绪状态.");
    }

    public void getCPU(ThreadContext context) {
        System.out.print("获得CPU时间-->");
        if (stateName.equals("就绪状态")) {
            context.setThreadState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}

//具体状态类：运行状态
class Running extends ThreadState {
    public Running() {
        stateName = "运行状态";
        System.out.println("当前线程处于：运行状态.");
    }

    public void suspend(ThreadContext context) {
        System.out.print("调用suspend()方法-->");
        if (stateName.equals("运行状态")) {
            context.setThreadState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    public void stop(ThreadContext context) {
        System.out.print("调用stop()方法-->");
        if (stateName.equals("运行状态")) {
            context.setThreadState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}

//具体状态类：阻塞状态
class Blocked extends ThreadState {
    public Blocked() {
        stateName = "阻塞状态";
        System.out.println("当前线程处于：阻塞状态.");
    }

    public void resume(ThreadContext context) {
        System.out.print("调用resume()方法-->");
        if (stateName.equals("阻塞状态")) {
            context.setThreadState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}

//具体状态类：死亡状态
class Dead extends ThreadState {
    public Dead() {
        stateName = "死亡状态";
        System.out.println("当前线程处于：死亡状态.");
    }
}