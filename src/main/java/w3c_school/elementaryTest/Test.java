package w3c_school.elementaryTest;

import java.time.Instant;

/**
 * @title: notice-service
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 通知公告
 * @date: Created at 3/29 0029 11:45
 */
public class Test {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getNano());
        System.out.println(instant.toEpochMilli());

    }

}

class TT {

//    boolean isLive;
//    boolean live;
    Integer isLive;
    int live;

    public Integer getIsLive() {
        return isLive;
    }

    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }
}