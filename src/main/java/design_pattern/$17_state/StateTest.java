package design_pattern.$17_state;

/**
 * @Author young
 * @Date 2020/5/28 18:02
 * @Desc 状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。
 **/
public class StateTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }

}

class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.HandleRequest(this);
    }
}

abstract class State {
    abstract void HandleRequest(Context context);
}

class ConcreteStateA extends State {

    @Override
    void HandleRequest(Context context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}


class ConcreteStateB extends State {

    @Override
    void HandleRequest(Context context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}
