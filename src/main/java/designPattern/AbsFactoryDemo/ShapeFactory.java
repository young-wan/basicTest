package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 创建Factory类，根据给定的信息扩展AbstractFactory以生成具体类的对象
 * @date: Created at 9/6 0006 17:11
 */
public class ShapeFactory extends AbsFactory {


    @Override
    Shape getShape(String shape) {
        if (shape.equals("circle")) {
            return new Circle();
        }
        if (shape.equals("angle")) {
            return new Angle();
        }
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        return null;
    }
}
