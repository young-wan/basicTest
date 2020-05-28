package design_pattern.$15_command;

/**
 * @Author young
 * @Date 2020/5/28 14:57
 * @Desc 命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
 **/
public class CommandTest {

    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }

}

//抽象命令
interface Command {
    abstract void execute();
}

//调用者
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}

//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
