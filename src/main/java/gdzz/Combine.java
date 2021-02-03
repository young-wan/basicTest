package gdzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author young
 * @Date 2021/2/2 14:52
 * @Desc
 **/
public enum Combine {
    CB_1(Equip.FEN_CHA.eId, Position.RING.posId),
    CB_2(Equip.FEN_CHA.eId, Position.NECKLACE.posId),
    CB_3(Equip.FEN_CHA.eId, Position.BOTH_HAND.posId),
    CB_4(Equip.XUE_LANG.eId, Position.HEAD.posId),
    CB_5(Equip.XUE_LANG.eId, Position.BODY.posId),
    CB_6(Equip.XUE_LANG.eId, Position.MAIN_HAND.posId),
    CB_7(Equip.XUE_LANG.eId, Position.MINOR_HAND.posId),
    CB_8(Equip.SHI_JIU.eId, Position.HEAD.posId),
    CB_9(Equip.SHI_JIU.eId, Position.BODY.posId),
    CB_10(Equip.SHI_JIU.eId, Position.SHOULDER.posId),
    CB_11(Equip.SHI_JIU.eId, Position.SHOE.posId),
    CB_12(Equip.QIAN_CHENG.eId, Position.SHOULDER.posId),
    CB_13(Equip.QIAN_CHENG.eId, Position.SHOE.posId),
    CB_14(Equip.QIAN_CHENG.eId, Position.RING.posId),
    CB_15(Equip.QIAN_CHENG.eId, Position.NECKLACE.posId),
    CB_16(Equip.GUANG_TAO.eId, Position.HEAD.posId),
    CB_17(Equip.GUANG_TAO.eId, Position.BODY.posId),
    CB_18(Equip.GUANG_TAO.eId, Position.MAIN_HAND.posId),
    CB_19(Equip.GUANG_TAO.eId, Position.MINOR_HAND.posId),
    CB_20(Equip.ZHU_FU.eId, Position.HEAD.posId),
    CB_21(Equip.ZHU_FU.eId, Position.BODY.posId),
    CB_22(Equip.ZHU_FU.eId, Position.SHOULDER.posId),
    CB_23(Equip.ZHU_FU.eId, Position.SHOE.posId),
    CB_24(Equip.ZHU_FU.eId, Position.BOTH_HAND.posId),
    CB_25(Equip.AN_YING.eId, Position.HEAD.posId),
    CB_26(Equip.AN_YING.eId, Position.BODY.posId),
    CB_27(Equip.AN_YING.eId, Position.RING.posId),
    CB_28(Equip.AN_YING.eId, Position.NECKLACE.posId),
    CB_29(Equip.TIAN_SHEN.eId, Position.HEAD.posId),
    CB_30(Equip.TIAN_SHEN.eId, Position.BODY.posId),
    CB_31(Equip.TIAN_SHEN.eId, Position.SHOULDER.posId),
    CB_32(Equip.TIAN_SHEN.eId, Position.SHOE.posId),
    CB_33(Equip.MU_YANG.eId, Position.SHOULDER.posId),
    CB_34(Equip.MU_YANG.eId, Position.SHOE.posId),
    CB_35(Equip.MU_YANG.eId, Position.RING.posId),
    CB_36(Equip.MU_YANG.eId, Position.NECKLACE.posId),
    CB_37(Equip.SHOU_HU.eId, Position.HEAD.posId),
    CB_38(Equip.SHOU_HU.eId, Position.BODY.posId),
    CB_39(Equip.SHOU_HU.eId, Position.SHOE.posId),
    CB_40(Equip.SHOU_HU.eId, Position.MAIN_HAND.posId),
    CB_41(Equip.SHOU_HU.eId, Position.MINOR_HAND.posId),
    CB_42(Equip.SHENG_MO.eId, Position.RING.posId),
    CB_43(Equip.SHENG_MO.eId, Position.NECKLACE.posId),
    CB_44(Equip.SHENG_MO.eId, Position.MAIN_HAND.posId),
    CB_45(Equip.SHENG_MO.eId, Position.MINOR_HAND.posId),
    CB_46(Equip.ZI_RAN.eId, Position.HEAD.posId),
    CB_47(Equip.ZI_RAN.eId, Position.BODY.posId),
    CB_48(Equip.ZI_RAN.eId, Position.SHOULDER.posId),
    CB_49(Equip.ZI_RAN.eId, Position.SHOE.posId),
    CB_50(Equip.ZI_RAN.eId, Position.BOTH_HAND.posId),
    CB_51(Equip.LIE_YAN.eId, Position.BODY.posId),
    CB_52(Equip.LIE_YAN.eId, Position.RING.posId),
    CB_53(Equip.LIE_YAN.eId, Position.NECKLACE.posId),
    CB_54(Equip.LIE_YAN.eId, Position.BOTH_HAND.posId),
    CB_55(Equip.JIN_WEI.eId, Position.HEAD.posId),
    CB_56(Equip.JIN_WEI.eId, Position.SHOULDER.posId),
    CB_57(Equip.JIN_WEI.eId, Position.SHOE.posId),
    CB_58(Equip.JIN_WEI.eId, Position.MAIN_HAND.posId),
    CB_59(Equip.JIN_WEI.eId, Position.MINOR_HAND.posId),
    CB_60(Equip.MING_YUN.eId, Position.SHOULDER.posId),
    CB_61(Equip.MING_YUN.eId, Position.SHOE.posId),
    CB_62(Equip.MING_YUN.eId, Position.RING.posId),
    CB_63(Equip.MING_YUN.eId, Position.NECKLACE.posId),
    CB_64(Equip.YUAN_SU.eId, Position.HEAD.posId),
    CB_65(Equip.YUAN_SU.eId, Position.BODY.posId),
    CB_66(Equip.YUAN_SU.eId, Position.MAIN_HAND.posId),
    CB_67(Equip.YUAN_SU.eId, Position.MINOR_HAND.posId),
    CB_68(Equip.HAI_YANG.eId, Position.HEAD.posId),
    CB_69(Equip.HAI_YANG.eId, Position.SHOULDER.posId),
    CB_70(Equip.HAI_YANG.eId, Position.RING.posId),
    CB_71(Equip.HAI_YANG.eId, Position.NECKLACE.posId),
    CB_72(Equip.BI_MENG.eId, Position.HEAD.posId),
    CB_73(Equip.BI_MENG.eId, Position.BODY.posId),
    CB_74(Equip.BI_MENG.eId, Position.SHOE.posId),
    CB_75(Equip.BI_MENG.eId, Position.MAIN_HAND.posId),
    CB_76(Equip.CHEN_XI.eId, Position.BODY.posId),
    CB_77(Equip.CHEN_XI.eId, Position.SHOE.posId),
    CB_78(Equip.CHEN_XI.eId, Position.MAIN_HAND.posId),
    CB_79(Equip.CHEN_XI.eId, Position.MINOR_HAND.posId),
    CB_80(Equip.XIE_LONG.eId, Position.SHOULDER.posId),
    CB_81(Equip.XIE_LONG.eId, Position.RING.posId),
    CB_82(Equip.XIE_LONG.eId, Position.NECKLACE.posId),
    CB_83(Equip.XIE_LONG.eId, Position.MINOR_HAND.posId),
    CB_84(Equip.SHENG_JIE.eId, Position.BODY.posId),
    CB_85(Equip.SHENG_JIE.eId, Position.RING.posId),
    CB_86(Equip.SHENG_JIE.eId, Position.NECKLACE.posId),
    CB_87(Equip.SHENG_JIE.eId, Position.MAIN_HAND.posId),
    CB_88(Equip.SHENG_JIE.eId, Position.MINOR_HAND.posId),
    CB_89(Equip.SHENG_LING.eId, Position.HEAD.posId),
    CB_90(Equip.SHENG_LING.eId, Position.BODY.posId),
    CB_91(Equip.SHENG_LING.eId, Position.SHOULDER.posId),
    CB_92(Equip.SHENG_LING.eId, Position.SHOE.posId),
    CB_93(Equip.SHENG_LING.eId, Position.RING.posId),
    CB_94(Equip.AO_SHU.eId, Position.HEAD.posId),
    CB_95(Equip.AO_SHU.eId, Position.BODY.posId),
    CB_96(Equip.AO_SHU.eId, Position.SHOE.posId),
    CB_97(Equip.AO_SHU.eId, Position.NECKLACE.posId),
    CB_98(Equip.AO_SHU.eId, Position.MAIN_HAND.posId),
    CB_99(Equip.DA_DI.eId, Position.HEAD.posId),
    CB_100(Equip.DA_DI.eId, Position.BODY.posId),
    CB_101(Equip.DA_DI.eId, Position.SHOULDER.posId),
    CB_102(Equip.DA_DI.eId, Position.RING.posId),
    CB_103(Equip.DA_DI.eId, Position.MAIN_HAND.posId),
    CB_104(Equip.XIAN_JI.eId, Position.HEAD.posId),
    CB_105(Equip.XIAN_JI.eId, Position.BODY.posId),
    CB_106(Equip.XIAN_JI.eId, Position.SHOULDER.posId),
    CB_107(Equip.XIAN_JI.eId, Position.MAIN_HAND.posId),
    CB_108(Equip.XIAN_JI.eId, Position.MINOR_HAND.posId),
    CB_109(Equip.GUANG_HUI.eId, Position.HEAD.posId),
    CB_110(Equip.GUANG_HUI.eId, Position.BODY.posId),
    CB_111(Equip.GUANG_HUI.eId, Position.SHOULDER.posId),
    CB_112(Equip.GUANG_HUI.eId, Position.MAIN_HAND.posId),
    CB_113(Equip.GUANG_HUI.eId, Position.MINOR_HAND.posId),
    CB_114(Equip.XING_CHEN.eId, Position.SHOULDER.posId),
    CB_115(Equip.XING_CHEN.eId, Position.RING.posId),
    CB_116(Equip.XING_CHEN.eId, Position.NECKLACE.posId),
    CB_117(Equip.XING_CHEN.eId, Position.MAIN_HAND.posId),
    CB_118(Equip.XING_CHEN.eId, Position.MINOR_HAND.posId),
    CB_119(Equip.XIANG_YA.eId, Position.BODY.posId),
    CB_120(Equip.XIANG_YA.eId, Position.SHOE.posId),
    CB_121(Equip.XIANG_YA.eId, Position.RING.posId),
    CB_122(Equip.XIANG_YA.eId, Position.NECKLACE.posId),
    CB_123(Equip.QI_SHI.eId, Position.HEAD.posId),
    CB_124(Equip.QI_SHI.eId, Position.BODY.posId),
    CB_125(Equip.QI_SHI.eId, Position.SHOULDER.posId),
    CB_126(Equip.QI_SHI.eId, Position.NECKLACE.posId),
    ;

    public Integer eId;

    public Integer posId;

    public Integer geteId() {
        return eId;
    }

    public Integer getPosId() {
        return posId;
    }

    Combine(Integer eId, Integer posId) {
        this.eId = eId;
        this.posId = posId;
    }


    public static List<Combine> getListByEId(Integer eId) {
        List<Combine> list = new ArrayList<>();
        Combine[] values = Combine.values();
        for (Combine value : values) {
            if (value.eId.equals(eId)) {
                list.add(value);
            }
        }
        return list;
    }


    public static List<Combine> getListByPosId(Integer posId, Integer low, Integer high) {
        List<Combine> list = new ArrayList<>();
        Combine[] values = Combine.values();
        for (Combine value : values) {
            if (value.posId.equals(posId) && Objects.requireNonNull(Equip.getById(value.eId)).level <= high &&
                    Objects.requireNonNull(Equip.getById(value.eId)).level >= low) {
                list.add(value);
            }
        }
        return list;
    }
}
