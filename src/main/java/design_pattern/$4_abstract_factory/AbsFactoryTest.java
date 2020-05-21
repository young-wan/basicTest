package design_pattern.$4_abstract_factory;

/**
 * @Author young
 * @Date 2020/5/21 15:46
 * @Desc 抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。
 **/
public class AbsFactoryTest {

    public static void main(String[] args) {
        Farm farm1 = new Farm1();
        Animal animal1 = farm1.newAnimal();
        animal1.show();
        Plant plant1 = farm1.newPlant();
        plant1.show();

        Farm farm2 = new Farm2();
        Animal animal2 = farm2.newAnimal();
        animal2.show();
        Plant plant2 = farm2.newPlant();
        plant2.show();
    }
}

// 抽象产品
interface Animal {
    void show();
}

// 具体产品
class Horse implements Animal {

    @Override
    public void show() {
        System.out.println("小马驹出生");
    }
}

class Cattle implements Animal {

    @Override
    public void show() {
        System.out.println("小牛出生");
    }
}

interface Plant {
    void show();
}

class Fruit implements Plant {

    @Override
    public void show() {
        System.out.println("生产水果");
    }
}

class Vegetable implements Plant {

    @Override
    public void show() {
        System.out.println("生产蔬菜");
    }
}

//  抽象工厂
interface Farm {

    Animal newAnimal();

    Plant newPlant();
}

// 具体工厂
class Farm1 implements Farm {

    @Override
    public Animal newAnimal() {
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        return new Fruit();
    }
}

class Farm2 implements Farm {

    @Override
    public Animal newAnimal() {
        return new Cattle();
    }

    @Override
    public Plant newPlant() {
        return new Vegetable();
    }
}