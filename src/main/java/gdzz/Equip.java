package gdzz;

import lombok.Data;

/**
 * @Author young
 * @Date 2021/2/2 14:44
 * @Desc
 **/
public enum Equip {
    FEN_CHA(1, "粪叉", 20),
    XUE_LANG(2, "血狼", 30),
    SHI_JIU(3, "狮鹫", 40),
    QIAN_CHENG(4, "虔诚", 50),
    GUANG_TAO(5, "光套", 50),
    ZHU_FU(6, "祝福", 60),
    AN_YING(7, "暗影", 60),
    TIAN_SHEN(8, "天神", 70),
    MU_YANG(9, "牧羊", 70),
    SHOU_HU(10, "守护", 70),
    SHENG_MO(11, "圣魔", 80),
    ZI_RAN(12, "自然", 80),
    LIE_YAN(13, "烈焰", 90),
    JIN_WEI(14, "禁卫", 90),
    MING_YUN(15, "命运", 100),
    YUAN_SU(16, "元素", 100),
    HAI_YANG(17, "海洋", 110),
    BI_MENG(18, "比蒙", 110),
    CHEN_XI(19, "晨曦", 120),
    XIE_LONG(20, "邪龙", 120),
    SHENG_JIE(21, "圣洁", 130),
    SHENG_LING(22, "生灵", 130),
    AO_SHU(23, "奥术", 140),
    DA_DI(24, "大帝", 140),
    XIAN_JI(25, "献祭", 150),
    GUANG_HUI(26, "光辉", 150),
    XING_CHEN(27, "星辰", 150),
    XIANG_YA(28, "象牙", 160),
    QI_SHI(29, "启示", 160),
    ;

    public Integer eId;

    public String eName;

    public Integer level;

    Equip(Integer eId, String eName, Integer level) {
        this.eId = eId;
        this.eName = eName;
        this.level = level;
    }
}
