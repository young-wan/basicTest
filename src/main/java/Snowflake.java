/**
 * WeChat
 * 雪花算法
 *
 * @author Young
 * @date 2020-04-24 14:42
 **/
public class Snowflake {

    // 定义起始的时间戳
    private static final long START_STAMP = 1480166465631L;

    // 定义各部分占位
    // 序列号占位
    private static final long SEQUENCE_BIT = 12L;
    // 机器码占位
    private static final long MACHINE_BIT = 5L;
    // 数据中心占位
    private static final long DATA_CENTER_BIT = 5L;

    // 定义对应占位部分最大数
    // -1L ^ (-1L << X)  等价于 (1L << X) - 1  等价于  ~(-1L << X)
    private static final long SEQUENCE_BIT_MAX = -1L ^ (-1L << SEQUENCE_BIT);
    private static final long MACHINE_BIT_MAX = (1L << MACHINE_BIT) - 1;
    private static final long DATA_CENTER_BIT_MAX = ~(-1L << DATA_CENTER_BIT);

    // 每部分左移数,让位
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATA_CENTER_LEFT = MACHINE_LEFT + MACHINE_BIT;
    private static final long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    // 定义初始数据
    private long sequence = 0L;   //  序号
    private long machineId = 1L; // 机器码id
    private long dataCenterId = 2L; // 数据中心id
    private long lastStamp = -1L; // 上一次用到的时间戳


    /**
     * 生成id
     *
     * @return
     */
    public long snowFlakeGenerate() {
        // 判定时钟回拨问题
        long curTimeMills = getCurTimeMills();
        if (curTimeMills < lastStamp) {
            throw new RuntimeException("clock move back, stop generate id");
        }
        if (curTimeMills == lastStamp) {
            // 和上一次使用的时间戳位于相同毫秒内,则sequence自增
            // & 操作用于限制获取的sequence不可超过设定的最大值SEQUENCE_BIT_MAX
            sequence = (sequence + 1) & SEQUENCE_BIT_MAX;
            if (sequence == 0L) {
                // 超过最大值,从下一毫秒再生成
                curTimeMills = getNextTimeMills(curTimeMills);
            }
        } else {
            // 不同毫秒内,则直接从0开始
            sequence = 0L;
        }
        // 定义上一次使用的时间戳
        lastStamp = curTimeMills;
        return (curTimeMills - START_STAMP)
                << TIMESTAMP_LEFT                             //时间戳部分
                | dataCenterId << DATA_CENTER_LEFT            //数据中心部分
                | machineId << MACHINE_LEFT                   //机器标识部分
                | sequence;                                   //序列号部分
    }

    /**
     * 获取下一个时间戳
     *
     * @param curStamp 传入的当前时间戳
     * @return
     */
    private long getNextTimeMills(long curStamp) {
        while (curStamp <= lastStamp) {
            // 如果当前时间小于上一次使用过的时间,则重复赋值最新时间戳
            curStamp = getCurTimeMills();
        }
        return curStamp;
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    private long getCurTimeMills() {
        return System.currentTimeMillis();
    }
}
