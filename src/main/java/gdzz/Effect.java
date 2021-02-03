package gdzz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author young
 * @Date 2021/2/2 15:56
 * @Desc
 **/
public enum Effect {
    FEN_CHA_2(Equip.FEN_CHA.eId, 2, Property.FG.propId, 5640),
    FEN_CHA_3(Equip.FEN_CHA.eId, 3, Property.SFL.propId, 15),
    XUE_LANG_2(Equip.XUE_LANG.eId, 2, Property.BJ.propId, 10),
    XUE_LANG_3(Equip.XUE_LANG.eId, 3, Property.SD.propId, 358),
    XUE_LANG_4(Equip.XUE_LANG.eId, 4, Property.LI.propId, 1194),
    SHI_JIU_2(Equip.SHI_JIU.eId, 2, Property.WG.propId, 9112),
    SHI_JIU_3(Equip.SHI_JIU.eId, 3, Property.SFL.propId, 15),
    SHI_JIU_4(Equip.SHI_JIU.eId, 4, Property.SD.propId, 462),
    QIAN_CHENG_2(Equip.QIAN_CHENG.eId, 2, Property.SFL.propId, 10),
    QIAN_CHENG_3(Equip.QIAN_CHENG.eId, 3, Property.ZHI.propId, 1887),
    QIAN_CHENG_4(Equip.QIAN_CHENG.eId, 4, Property.SD.propId, 566),
    GUANG_TAO_2(Equip.GUANG_TAO.eId, 2, Property.LI.propId, 1887),
    GUANG_TAO_3(Equip.GUANG_TAO.eId, 3, Property.SFL.propId, 15),
    GUANG_TAO_4(Equip.GUANG_TAO.eId, 4, Property.HP.propId, 75000),
    ZHU_FU_2(Equip.ZHU_FU.eId, 2, Property.HP.propId, 83000),
    ZHU_FU_3(Equip.ZHU_FU.eId, 3, Property.ZHI.propId, 2094),
    ZHU_FU_4(Equip.ZHU_FU.eId, 4, Property.SD.propId, 628),
    ZHU_FU_5(Equip.ZHU_FU.eId, 5, Property.SFL.propId, 25),
    AN_YING_2(Equip.AN_YING.eId, 2, Property.LI.propId, 2234),
    AN_YING_3(Equip.AN_YING.eId, 3, Property.SFL.propId, 15),
    AN_YING_4(Equip.AN_YING.eId, 4, Property.SD.propId, 670),
    TIAN_SHEN_2(Equip.TIAN_SHEN.eId, 2, Property.LI.propId, 2580),
    TIAN_SHEN_3(Equip.TIAN_SHEN.eId, 3, Property.SFL.propId, 15),
    TIAN_SHEN_4(Equip.TIAN_SHEN.eId, 4, Property.SD.propId, 774),
    MU_YANG_2(Equip.MU_YANG.eId, 2, Property.BJ.propId, 21),
    MU_YANG_3(Equip.MU_YANG.eId, 3, Property.SFL.propId, 15),
    MU_YANG_4(Equip.MU_YANG.eId, 4, Property.SD.propId, 774),
    SHOU_HU_2(Equip.SHOU_HU.eId, 2, Property.FF.propId, 7636),
    SHOU_HU_3(Equip.SHOU_HU.eId, 3, Property.SD.propId, 726),
    SHOU_HU_4(Equip.SHOU_HU.eId, 4, Property.SFL.propId, 20),
    SHOU_HU_5(Equip.SHOU_HU.eId, 5, Property.TI.propId, 2419),
    SHENG_MO_2(Equip.SHENG_MO.eId, 2, Property.SFL.propId, 10),
    SHENG_MO_3(Equip.SHENG_MO.eId, 3, Property.ZHI.propId, 2926),
    SHENG_MO_4(Equip.SHENG_MO.eId, 4, Property.SD.propId, 878),
    ZI_RAN_2(Equip.ZI_RAN.eId, 2, Property.BJ.propId, 22),
    ZI_RAN_3(Equip.ZI_RAN.eId, 3, Property.SFL.propId, 15),
    ZI_RAN_4(Equip.ZI_RAN.eId, 4, Property.SD.propId, 823),
    ZI_RAN_5(Equip.ZI_RAN.eId, 5, Property.LI.propId, 2744),
    LIE_YAN_2(Equip.LIE_YAN.eId, 2, Property.SFL.propId, 10),
    LIE_YAN_3(Equip.LIE_YAN.eId, 3, Property.SD.propId, 982),
    LIE_YAN_4(Equip.LIE_YAN.eId, 4, Property.ZHI.propId, 3273),
    JIN_WEI_2(Equip.JIN_WEI.eId, 2, Property.TI.propId, 3068),
    JIN_WEI_3(Equip.JIN_WEI.eId, 3, Property.KB.propId, 25),
    JIN_WEI_4(Equip.JIN_WEI.eId, 4, Property.SFL.propId, 20),
    JIN_WEI_5(Equip.JIN_WEI.eId, 5, Property.SD.propId, 921),
    MING_YUN_2(Equip.MING_YUN.eId, 2, Property.LI.propId, 3619),
    MING_YUN_3(Equip.MING_YUN.eId, 3, Property.TI.propId, 3619),
    MING_YUN_4(Equip.MING_YUN.eId, 4, Property.SD.propId, 1086),
    YUAN_SU_2(Equip.YUAN_SU.eId, 2, Property.ZHI.propId, 3619),
    YUAN_SU_3(Equip.YUAN_SU.eId, 3, Property.SD.propId, 1086),
    YUAN_SU_4(Equip.YUAN_SU.eId, 4, Property.SFL.propId, 20),
    HAI_YANG_2(Equip.HAI_YANG.eId, 2, Property.ZHI.propId, 3966),
    HAI_YANG_3(Equip.HAI_YANG.eId, 3, Property.SFL.propId, 15),
    HAI_YANG_4(Equip.HAI_YANG.eId, 4, Property.TI.propId, 3966),
    BI_MENG_2(Equip.BI_MENG.eId, 2, Property.LI.propId, 3966),
    BI_MENG_3(Equip.BI_MENG.eId, 3, Property.TI.propId, 3966),
    BI_MENG_4(Equip.BI_MENG.eId, 4, Property.SD.propId, 1190),
    CHEN_XI_2(Equip.CHEN_XI.eId, 2, Property.FG.propId, 25000),
    CHEN_XI_3(Equip.CHEN_XI.eId, 3, Property.ZHI.propId, 4313),
    CHEN_XI_4(Equip.CHEN_XI.eId, 4, Property.SD.propId, 1294),
    XIE_LONG_2(Equip.XIE_LONG.eId, 2, Property.HP.propId, 17000),
    XIE_LONG_3(Equip.XIE_LONG.eId, 3, Property.SFL.propId, 15),
    XIE_LONG_4(Equip.XIE_LONG.eId, 4, Property.WG.propId, 25000),
    SHENG_JIE_2(Equip.SHENG_JIE.eId, 2, Property.SFL.propId, 10),
    SHENG_JIE_3(Equip.SHENG_JIE.eId, 3, Property.TI.propId, 4386),
    SHENG_JIE_4(Equip.SHENG_JIE.eId, 4, Property.ZHI.propId, 4386),
    SHENG_JIE_5(Equip.SHENG_JIE.eId, 5, Property.REN.propId, 4386),
    SHENG_LING_2(Equip.SHENG_LING.eId, 2, Property.WG.propId, 25000),
    SHENG_LING_3(Equip.SHENG_LING.eId, 3, Property.LI.propId, 4386),
    SHENG_LING_4(Equip.SHENG_LING.eId, 4, Property.SFL.propId, 20),
    SHENG_LING_5(Equip.SHENG_LING.eId, 5, Property.HP.propId, 17000),
    AO_SHU_2(Equip.AO_SHU.eId, 2, Property.FG.propId, 27000),
    AO_SHU_3(Equip.AO_SHU.eId, 3, Property.HP.propId, 180000),
    AO_SHU_4(Equip.AO_SHU.eId, 4, Property.SFL.propId, 20),
    AO_SHU_5(Equip.AO_SHU.eId, 5, Property.MIN.propId, 4693),
    DA_DI_2(Equip.DA_DI.eId, 2, Property.WG.propId, 27000),
    DA_DI_3(Equip.DA_DI.eId, 3, Property.SFL.propId, 15),
    DA_DI_4(Equip.DA_DI.eId, 4, Property.HP.propId, 180000),
    DA_DI_5(Equip.DA_DI.eId, 5, Property.SD.propId, 1408),
    XIAN_JI_2(Equip.XIAN_JI.eId, 2, Property.FG.propId, 29000),
    XIAN_JI_3(Equip.XIAN_JI.eId, 3, Property.SFL.propId, 15),
    XIAN_JI_4(Equip.XIAN_JI.eId, 4, Property.ZHI.propId, 5018),
    XIAN_JI_5(Equip.XIAN_JI.eId, 5, Property.SD.propId, 1505),
    GUANG_HUI_2(Equip.GUANG_HUI.eId, 2, Property.WG.propId, 29000),
    GUANG_HUI_3(Equip.GUANG_HUI.eId, 3, Property.BJ.propId, 30),
    GUANG_HUI_4(Equip.GUANG_HUI.eId, 4, Property.SFL.propId, 20),
    GUANG_HUI_5(Equip.GUANG_HUI.eId, 5, Property.MIN.propId, 5018),
    XING_CHEN_2(Equip.XING_CHEN.eId, 2, Property.KB.propId, 30),
    XING_CHEN_3(Equip.XING_CHEN.eId, 3, Property.TI.propId, 5018),
    XING_CHEN_4(Equip.XING_CHEN.eId, 4, Property.HP.propId, 200000),
    XING_CHEN_5(Equip.XING_CHEN.eId, 5, Property.SFL.propId, 25),
    XIANG_YA_2(Equip.XIANG_YA.eId, 2, Property.ZHI.propId, 5343),
    XIANG_YA_3(Equip.XIANG_YA.eId, 3, Property.SFL.propId, 15),
    XIANG_YA_4(Equip.XIANG_YA.eId, 4, Property.BJ.propId, 35),
    QI_SHI_2(Equip.QI_SHI.eId, 2, Property.LI.propId, 5343),
    QI_SHI_3(Equip.QI_SHI.eId, 3, Property.SFL.propId, 15),
    QI_SHI_4(Equip.QI_SHI.eId, 4, Property.TI.propId, 5343),
    ;

    private Integer eId;

    private Integer sum;

    private Integer propId;

    private Integer data;

    public Integer geteId() {
        return eId;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getPropId() {
        return propId;
    }

    public Integer getData() {
        return data;
    }

    Effect(Integer eId, Integer sum, Integer propId, Integer data) {
        this.eId = eId;
        this.sum = sum;
        this.propId = propId;
        this.data = data;
    }

    public static List<Effect> getListByMap(Collection<Combine> combines) {
        Map<Integer, List<Combine>> collect = combines.stream().collect(Collectors.groupingBy(Combine::geteId));
        List<Effect> res = new ArrayList<>();
        for (Integer eId : collect.keySet()) {
            res.addAll(getDetailEffect(eId, collect.get(eId).size()));
        }
        return res;
    }

    private static List<Effect> getDetailEffect(Integer eId, Integer sum) {
        List<Effect> list = getListByEId(eId);
        List<Effect> res = new ArrayList<>();
        for (Effect effect : list) {
            if (effect.sum <= sum) {
                res.add(effect);
            }
        }
        return res;
    }


    public static List<Effect> getListByEId(Integer eId) {
        List<Effect> list = new ArrayList<>();
        Effect[] values = Effect.values();
        for (Effect value : values) {
            if (value.eId.equals(eId)) {
                list.add(value);
            }
        }
        return list;
    }
}
