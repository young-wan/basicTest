package design_pattern.$9_decorator;

/**
 * @Author young
 * @Date 2020/5/27 9:39
 * @Desc 装饰（Decorator）模式：动态的给对象增加一些职责，即增加其额外的功能。
 **/
public class DecoratorTest {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("----------------------");
        Component d = new ConcreteDecorator(component);
        d.operation();
    }

}

//抽象构件角色
interface Component {
    void operation();
}

//具体构件角色
class ConcreteComponent implements Component {

    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}

//抽象装饰角色
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

//具体装饰角色
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}

