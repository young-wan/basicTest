package designPattern.cardPlay;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/07/12 11:45
 */
public enum TypeEnum {

    A(4, "A卡", 0.69, 58, 51),
    S(3, "S卡", 0.20, 25, 26),
    SS(2, "SS卡", 0.10, 15, 11),
    SSS(1, "SSS卡", 0.01, 10, 1);

    private int key;

    private String name;

    private double ran;

    private int total;

    private int start;


    TypeEnum(int key, String name, double ran, int total, int start) {
        this.key = key;
        this.name = name;
        this.ran = ran;
        this.total = total;
        this.start = start;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getRan() {
        return ran;
    }

    public int getTotal() {
        return total;
    }

    public int getStart() {
        return start;
    }

    public String getName(int key) {
        for (TypeEnum e : values()) {
            if (e.getKey() == key) {
                return e.getName();
            }
        }
        return null;
    }
}
