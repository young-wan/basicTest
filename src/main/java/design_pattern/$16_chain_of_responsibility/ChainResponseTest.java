package design_pattern.$16_chain_of_responsibility;

/**
 * @Author young
 * @Date 2020/5/28 16:02
 * @Desc 职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。
 **/
public class ChainResponseTest {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("one");
        handler1.handleRequest("two");
        handler1.handleRequest("three");
    }

}

abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("one".equals(request)) {
            System.out.println("具体处理者1负责处理该请求！");
        } else if (null != getNext()) {
            getNext().handleRequest(request);
        } else {
            System.out.println("没有人处理该请求！");
        }
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("two".equals(request)) {
            System.out.println("具体处理者2负责处理该请求！");
        } else if (null != getNext()) {
            getNext().handleRequest(request);
        } else {
            System.out.println("没有人处理该请求！");
        }
    }
}
