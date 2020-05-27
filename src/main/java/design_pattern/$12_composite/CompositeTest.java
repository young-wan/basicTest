package design_pattern.$12_composite;

import java.util.ArrayList;

/**
 * @Author young
 * @Date 2020/5/27 16:38
 * @Desc 组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。
 **/

//透明式的组合模式
public class CompositeTest {
    public static void main(String[] args) {
        Component branch1 = new Branch();
        Component branch2 = new Branch();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        branch1.add(leaf1);
        branch1.add(branch2);
        branch2.add(leaf2);
        branch2.add(leaf3);
        branch1.operation();
    }
}

//抽象构件
interface Component {
    void add(Component component);

    void remove(Component component);

    Component getChild(int i);

    void operation();
}

//树叶构件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}

//树枝构件
class Branch implements Component {
    private ArrayList<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
