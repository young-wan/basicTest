import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author young
 * @Date 2021/1/11 11:16
 * @Desc
 **/
public class SDFUtils {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static String format(Date date) {
        SimpleDateFormat sdf = THREAD_LOCAL.get();
        THREAD_LOCAL.remove();
        return sdf.format(date);
    }

    public static Date parse(String str) {
        SimpleDateFormat sdf = THREAD_LOCAL.get();
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
