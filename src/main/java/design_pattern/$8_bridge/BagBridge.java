package design_pattern.$8_bridge;

/**
 * @Author young
 * @Date 2020/5/27 9:14
 * @Desc
 **/
public class BagBridge {

    public static void main(String[] args) {
        Color color = new Red();
        Bag bag = new HandBag();
        bag.setColor(color);
        System.out.println(bag.getName());
    }

}

//实现化角色：颜色
interface Color {
    String getColor();
}

//具体实现化角色：黄色
class Yellow implements Color {

    @Override
    public String getColor() {
        return "yellow";
    }
}

class Red implements Color {

    @Override
    public String getColor() {
        return "red";
    }
}

//抽象化角色：包
abstract class Bag {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag {

    @Override
    public String getName() {
        return color.getColor() + ": HandBag";
    }
}

class Wallet extends Bag {

    @Override
    public String getName() {
        return color.getColor() + ": Wallet";
    }
}