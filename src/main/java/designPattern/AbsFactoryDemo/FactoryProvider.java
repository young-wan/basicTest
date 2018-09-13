package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 创建一个Factory生成器/生产器类，通过传递Shape或Printer等信息来获取工厂。
 * @date: Created at 9/6 0006 17:18
 */
public class FactoryProvider {
    public static AbsFactory getFactory(String choice) {
        if (choice.equals("shape")) {
            return new ShapeFactory();
        }
        if (choice.equals("printer")) {
            return new PrinterFactory();
        }
        return null;
    }
}
