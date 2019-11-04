package designPattern.cardPlay;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/07/12 11:42
 */
public class CardPlay {

    private String name;

    private int sort;

    private int type;

    private String typeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "\n您抽到了: {" +
                "name='" + name + '\'' +
                ", sort=" + sort +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
