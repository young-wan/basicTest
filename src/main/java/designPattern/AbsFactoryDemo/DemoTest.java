package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 9/6 0006 17:15
 */
public class DemoTest {
    //
    public static void main(String[] args) {
        AbsFactory shape = FactoryProvider.getFactory("shape");
        AbsFactory printer = FactoryProvider.getFactory("printer");

        Shape shape1 = shape.getShape("circle");
        shape1.getShape();

        Shape shape2 = shape.getShape("angle");
        shape2.getShape();

        Printer printer1 = printer.getPrinter("paper");
        Printer printer2 = printer.getPrinter("web");
        printer1.getPrinter();
        printer2.getPrinter();

        Shape shape3 = shape.getShape("ds");
        shape3.getShape();
    }


}
