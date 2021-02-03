package gdzz;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author young
 * @Date 2021/2/2 14:22
 * @Desc 11
 * <p>
 * equip:
 * e_id, e_name
 * <p>
 * position:
 * pos_id, pos_name
 * <p>
 * property:
 * prop_id, prop_name
 * <p>
 * combine:
 * e_id, pos_id
 * <p>
 * effect:
 * e_id, sum, prop_id, data
 **/
public class Test {
    public static void main(String[] args) {
        int low = 0;
        int high = 40;
        int type = 1;
//        int type = 2;

        List<Combine> headList = Combine.getListByPosId(Position.HEAD.posId, low, high);
        List<Combine> bodyList = Combine.getListByPosId(Position.BODY.posId, low, high);
        List<Combine> shoulderList = Combine.getListByPosId(Position.SHOULDER.posId, low, high);
        List<Combine> shoeList = Combine.getListByPosId(Position.SHOE.posId, low, high);
        List<Combine> ringList = Combine.getListByPosId(Position.RING.posId, low, high);
        List<Combine> necklaceList = Combine.getListByPosId(Position.NECKLACE.posId, low, high);
        List<Combine> mainHandList = Combine.getListByPosId(Position.MAIN_HAND.posId, low, high);
        List<Combine> minorHandList = Combine.getListByPosId(Position.MINOR_HAND.posId, low, high);
        List<Combine> bothHandList = Combine.getListByPosId(Position.BOTH_HAND.posId, low, high);

        List<Map<Position, Combine>> list = new ArrayList<>();
        for (Combine head : headList) {
            Map<Position, Combine> map = new HashMap<>();
            map.put(Position.HEAD, head);
            for (Combine body : bodyList) {
                map.put(Position.BODY, body);
                for (Combine shoulder : shoulderList) {
                    map.put(Position.SHOULDER, shoulder);
                    for (Combine shoe : shoeList) {
                        map.put(Position.SHOE, shoe);
                        for (Combine ring : ringList) {
                            map.put(Position.RING, ring);
                            for (Combine necklace : necklaceList) {
                                map.put(Position.NECKLACE, necklace);
                                int rate = 15;
                                if (type == 1) {
                                    for (Combine bothHand : bothHandList) {
                                        map.put(Position.BOTH_HAND, bothHand);
                                        if (offer(map, rate, Property.SFL)) {
                                            if (!list.contains(map)) {
                                                list.add((Map<Position, Combine>) deepClone(map));
                                            }
                                        }
                                    }
                                }
                                if (type == 2) {
                                    for (Combine mainHand : mainHandList) {
                                        map.put(Position.MAIN_HAND, mainHand);
                                        for (Combine minorHand : minorHandList) {
                                            map.put(Position.MINOR_HAND, minorHand);
                                            if (offer(map, rate, Property.SFL)) {
                                                list.add(map);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(outputStr(list));

    }

    /**
     * 校验是否满足条件
     *
     * @param map
     * @param rate
     * @return
     */
    private static Boolean offer(Map<Position, Combine> map, Integer rate, Property property) {
        Map<Property, Integer> effectRes = getEffects(map);
        Integer d = effectRes.get(property);
        if (null == d) {
            return false;
        }
        return d >= rate;
    }

    private static Map<Property, Integer> getEffects(Map<Position, Combine> map) {
        List<Effect> effectList = Effect.getListByMap(map.values());
        Map<Integer, List<Effect>> collect = effectList.stream().collect(Collectors.groupingBy(Effect::getPropId));
        Map<Property, Integer> effectRes = new HashMap<>();
        for (Integer propId : collect.keySet()) {
            int data;
            List<Effect> effects = collect.get(propId);
            data = effects.stream().mapToInt(Effect::getData).sum();
            effectRes.put(Property.getById(propId), data);
        }
        return effectRes;
    }

    private static String outputStr(List<Map<Position, Combine>> list) {
        System.out.println("------------------");
        StringBuilder sb = new StringBuilder("所选装备为： ");
        sb.append("(").append(list.size()).append(")\n");
        for (Map<Position, Combine> map : list) {
            Map<Position, Combine> treeMap = new TreeMap<>((o1, o2) -> {
                if (o1.posId < o2.posId) return -1;
                else if (o1.posId > o2.posId) return 1;
                return 0;
            });
            treeMap.putAll(map);
            sb.append("\n===============>");
            for (Position position : treeMap.keySet()) {
                sb.append(position.posName).append(" : ").append(Equip.getById(map.get(position).eId).eName).append("   ");
            }
            sb.append("\n套装效果为： ");
            Map<Property, Integer> effectRes = getEffects(map);
            for (Property property : effectRes.keySet()) {
                sb.append(property.propName).append(" : ").append(effectRes.get(property)).append("   ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static Object deepClone(Object obj) {
        try {// 将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);// 从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (oi.readObject());
        } catch (Exception e) {
            return null;
        }
    }
}
