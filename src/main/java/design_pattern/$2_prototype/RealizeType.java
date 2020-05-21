package design_pattern.$2_prototype;

/**
 * @Author young
 * @Date 2020/5/21 9:43
 * @Desc 原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。
 **/
public class RealizeType implements Cloneable {

    public RealizeType() {
        System.out.println("原型创建成功");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("原型复制成功");
        return (RealizeType) super.clone();
    }
}

class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType r1 = new RealizeType();
        RealizeType r2 = r1.clone();
        System.out.println(r1 == r2);
    }
}
