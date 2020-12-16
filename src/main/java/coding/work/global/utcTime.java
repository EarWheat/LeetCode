package coding.work.global;

import com.xiaoju.elvish.sdk.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-15 17:08
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class utcTime {
    public static int queryHourByCity(long city_id, long ct) throws Exception {
        String dateStr = DateTimeUtil.formatByCity(city_id, ct);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(dateStr);
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }
}
