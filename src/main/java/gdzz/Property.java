package gdzz;

/**
 * @Author young
 * @Date 2021/2/2 14:00
 * @Desc 类型
 **/
public enum Property {
    TI(1, "体"),
    MIN(2, "敏"),
    ZHI(3, "智"),
    LI(4, "力"),
    REN(5, "韧"),
    HP(6, "生命"),
    SD(7, "速度"),
    WG(8, "物攻"),
    WF(9, "物防"),
    FG(10, "法攻"),
    FF(11, "法防"),
    SFL(12, "施法率"),
    KB(13, "抗暴"),
    BJ(14, "暴击"),
    ;
    public Integer propId;

    public String propName;

    Property(Integer propId, String propName) {
        this.propId = propId;
        this.propName = propName;
    }
}
