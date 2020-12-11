package coding.Newton;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-11 15:21
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class isPassengerLate {
    public static boolean isPassengerLate(String arriveTime, Long passengerLateTime, String departureTime, Boolean carPool) throws ParseException {
        if(StringUtils.isBlank(arriveTime) || arriveTime.equals("0000-00-00 00:00:00")){
            return false;
        }
        try {
            Long currentTime = System.currentTimeMillis()/1000;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long arriveTimeStamp = simpleDateFormat.parse(arriveTime).getTime()/1000;
            long departureTimeStamp = simpleDateFormat.parse(departureTime).getTime()/1000;
            long passengerLateTimeStamp = arriveTimeStamp + (passengerLateTime * 60);
            Long finalPaxLateTime = carPool ? departureTimeStamp : passengerLateTimeStamp;
            return currentTime > finalPaxLateTime;
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) throws ParseException {
        String arriveTime = "2020-12-11 15:37:27";
        Long passengerLateTime = 4L;
        String departureTime = "2020-12-11 15:25:30";
        boolean carPool = false;
        System.out.println(isPassengerLate(arriveTime,passengerLateTime,departureTime,carPool));
    }
}
