package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/25 14:45
 */
public class TimeUtil {

    public static String logNow() {
        String now = String.valueOf(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "."
                + now.substring(now.length() - 3);
    }

}
