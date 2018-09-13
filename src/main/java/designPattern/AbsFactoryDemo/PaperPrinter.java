package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 实现Printer接口的具体类-paper
 * @date: Created at 9/6 0006 17:10
 */
public class PaperPrinter implements Printer {
    @Override
    public void getPrinter() {
        System.out.println("this is a paper printer");
    }
}
