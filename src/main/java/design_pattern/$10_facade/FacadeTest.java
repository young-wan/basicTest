package design_pattern.$10_facade;

/**
 * @Author young
 * @Date 2020/5/27 10:27
 * @Desc 外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
 **/
public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}

class Facade {
    private SubSystem1 system1 = new SubSystem1();
    private SubSystem2 system2 = new SubSystem2();
    private SubSystem3 system3 = new SubSystem3();

    public void method() {
        system1.method1();
        system2.method2();
        system3.method3();
    }

}

class SubSystem1 {
    public void method1() {
        System.out.println("子系统01的method1()被调用！");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("子系统02的method2()被调用！");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("子系统03的method3()被调用！");
    }
}


