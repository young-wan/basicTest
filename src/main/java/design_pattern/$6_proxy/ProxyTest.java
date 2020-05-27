package design_pattern.$6_proxy;

/**
 * @Author young
 * @Date 2020/5/21 19:07
 * @Desc 代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
 **/
public class ProxyTest {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }

}

// 抽象主题
interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("realSubject request ...");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("proxy preRequest ...");
    }

    private void postRequest() {
        System.out.println("proxy postRequest ...");
    }
}
