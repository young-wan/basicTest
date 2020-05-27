package design_pattern.$12_composite;

import java.util.ArrayList;

/**
 * @Author young
 * @Date 2020/5/27 16:53
 * @Desc
 **/

// 安全组合模式
public class ShoppingTest {
    public static void main(String[] args) {
        float s = 0;
        Bags BigBag, mediumBag, smallRedBag, smallWhiteBag;
        Goods sp;
        BigBag = new Bags("大袋子");
        mediumBag = new Bags("中袋子");
        smallRedBag = new Bags("红色小袋子");
        smallWhiteBag = new Bags("白色小袋子");
        sp = new Goods("婺源特产", 2, 7.9f);
        smallRedBag.add(sp);
        sp = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(sp);
        sp = new Goods("韶关香菇", 2, 68);
        smallWhiteBag.add(sp);
        sp = new Goods("韶关红茶", 3, 180);
        smallWhiteBag.add(sp);
        sp = new Goods("景德镇瓷器", 1, 380);
        mediumBag.add(sp);
        mediumBag.add(smallRedBag);
        sp = new Goods("李宁牌运动鞋", 1, 198);
        BigBag.add(sp);
        BigBag.add(smallWhiteBag);
        BigBag.add(mediumBag);
        System.out.println("您选购的商品有：");
        BigBag.show();
        s = BigBag.calc();
        System.out.println("要支付的总价是：" + s + "元");
    }
}

//抽象构件：物品
interface Articles {

    float calc();

    void show();
}

//树叶构件：商品
class Goods implements Articles {
    private String name;

    private int quantity;

    private float unitPrice;


    public Goods(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calc() {
        return unitPrice * quantity;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + unitPrice + "元)");
    }
}

//树枝构件：袋子
class Bags implements Articles {
    private String name;
    private ArrayList<Articles> bags = new ArrayList<>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles articles) {
        bags.add(articles);
    }

    public void remove(Articles articles) {
        bags.remove(articles);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }

    @Override
    public float calc() {
        float res = 0;
        for (Object obj : bags) {
            res += ((Articles) obj).calc();
        }
        return res;
    }

    @Override
    public void show() {
        for (Object obj : bags) {
            ((Articles) obj).show();
        }
    }
}