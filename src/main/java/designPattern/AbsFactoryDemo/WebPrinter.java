package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 实现Printer接口的具体类-web
 * @date: Created at 9/6 0006 17:10
 */
public class WebPrinter implements Printer {
    @Override
    public void getPrinter() {
        System.out.println("this is a web printer");
    }
}
