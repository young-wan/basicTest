package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 实现Shape接口的具体类-circle
 * @date: Created at 9/6 0006 17:09
 */
public class Circle extends Angle implements Shape{
    public static String st =  "11";
    @Override
    public void getShape() {
        System.out.println("this is a circle!");
    }
}
