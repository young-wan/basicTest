package gdzz;

/**
 * @Author young
 * @Date 2021/2/2 13:48
 * @Desc 部位
 **/
public enum Position {
    HEAD(1, "头"),
    BODY(2, "身体"),
    SHOULDER(3, "肩膀"),
    SHOE(4, "鞋子"),
    RING(5, "戒指"),
    NECKLACE(6, "项链"),
    MAIN_HAND(7, "主手"),
    MINOR_HAND(8, "副手"),
    BOTH_HAND(9, "双手"),
    ;


    public Integer posId;

    public String posName;

    Position(Integer posId, String posName) {
        this.posId = posId;
        this.posName = posName;
    }
}
