package design_pattern.$22_memento;

/**
 * @Author young
 * @Date 2020/5/29 13:15
 * @Desc 备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。
 **/
public class MementoTest {

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.setState("S0");
        System.out.println("初始状态: " + starter.getState());
        Manager manager = new Manager();
        manager.setMemento(starter.createMemento(starter.getState()));
        starter.setState("S1");
        System.out.println("更改状态: " + starter.getState());
        starter.restoreMemento(manager.getMemento());
        System.out.println("恢复状态: " + starter.getState());
    }

}

// 备忘录
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

// 发起人
class Starter {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(String state) {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}

// 管理者
class Manager{
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

