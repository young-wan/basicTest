package other_pack;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author young
 * @Date 2020/7/23 14:02
 * @Desc
 **/
public class JdkProxyDemo implements InvocationHandler {
    private Object target;

    public JdkProxyDemo(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before ===");
        method.invoke(target, args);
        System.out.println("invoke before ===");
        return null;
    }

    public static void main(String[] args) {
        Model model = new ModelImpl();
        JdkProxyDemo demo = new JdkProxyDemo(model);
        Model proxy = (Model) Proxy.newProxyInstance(model.getClass().getClassLoader(), model.getClass().getInterfaces(), demo);
        proxy.method();
    }
}


interface Model {
    void method();
}

class ModelImpl implements Model {

    @Override
    public void method() {
        System.out.println("model method invoke ===");
    }
}

