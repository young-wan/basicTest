package design_pattern.$14_strategy;

/**
 * @Author young
 * @Date 2020/5/28 14:42
 * @Desc 策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。
 **/
public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategyA = new ConcreteClassA();
        context.setStrategy(strategyA);
        context.strategyMethod();
        System.out.println("----------------------");
        Strategy strategyB = new ConcreteClassB();
        context.setStrategy(strategyB);
        context.strategyMethod();
    }

}

interface Strategy {
    void strategyMethod();
}

class ConcreteClassA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}

class ConcreteClassB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}

class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
