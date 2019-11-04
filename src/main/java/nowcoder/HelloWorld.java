package nowcoder;


/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/15 15:07
 */
public class HelloWorld {
    private String message;

    private char aChar;

    private int i;

    @Override
    public String toString() {
        return "HelloWorld{" +
                "message='" + message + '\'' +
                ", aChar=" + aChar +
                ", i=" + i +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().toString());
    }

    public void getMessage() {
        System.out.println("your message: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("bean is init");
    }

    public void destroy() {
        System.out.println("bean is destroy");
    }
}
