package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 创建一个抽象类来获取打印机和形状对象的工厂
 * @date: Created at 9/6 0006 17:12
 */
public abstract class AbsFactory {
    abstract Shape getShape(String shape);

    abstract Printer getPrinter(String type);
}
