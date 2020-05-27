package design_pattern.$8_bridge;

/**
 * @Author young
 * @Date 2020/5/27 9:05
 * @Desc 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 **/
public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.Operation();
    }

}

//实现化角色
interface Implementor {
    void OperationImpl();
}

//具体实现化角色
class ConcreteImplementorA implements Implementor {

    @Override
    public void OperationImpl() {
        System.out.println("具体实现化(Concrete ImplementorA)角色被访问");
    }
}

//抽象化角色
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void Operation();
}

//扩展抽象化角色
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        implementor.OperationImpl();
    }
}

