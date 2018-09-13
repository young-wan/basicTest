package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 创建Factory类，根据给定的信息扩展AbstractFactory以生成具体类的对象
 * @date: Created at 9/6 0006 17:12
 */
public class PrinterFactory extends AbsFactory {

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        if (type.equals("web")) {
            return new WebPrinter();
        }
        if (type.equals("paper")) {
            return new PaperPrinter();
        }
        return null;
    }
}
