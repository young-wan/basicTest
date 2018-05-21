package wechat.module;

import java.io.Serializable;

/**
 * @Author: Young
 * @Description: Java测试实体类
 * @Date: Created at 9/21 0021 10:49
 */
public class TestModule implements Serializable{
    private String name;
    private Integer age;

    public TestModule(String name, Integer age){
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestModule{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
