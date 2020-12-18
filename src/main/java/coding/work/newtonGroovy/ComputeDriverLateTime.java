package coding.work.newtonGroovy;

import coding.Pack;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-18 10:05
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ComputeDriverLateTime {
    /**
     * 计算司机迟到时间
     * @param isCarPool 是否为拼车单
     * @param isUpdateDest  是否变更目的地
     * @param arriveTime    司机到达时间
     * @param departureTime 订单出发时间
     * @param driverLateTime 司机迟到时间
     * @param ETA   预估时间
     * @return
     */
    public boolean isDriverLate(boolean isCarPool, boolean isUpdateDest,  Long arriveTime, Long departureTime, Long driverLateTime, Long striveTime,Long ETA, boolean gray, String ABGroup){
        Date date = new Date();
        Long nowTime = date.getTime()/1000;
        Long lateTime;  // 迟到时间
        // 拼车单
        if(isCarPool){
            lateTime = departureTime;
        } else {
            // ETA为空
            if(ETA == null){
                lateTime = striveTime + driverLateTime * 60;
            } else {
                if(gray || ABGroup.equals("treatment_group_two")){
                    lateTime =  striveTime + (ETA + 5) * 60;
                } else if(ABGroup.equals("treatment_group")){
                    lateTime =  striveTime + (ETA + 3) * 60;
                } else {
                    lateTime = striveTime + driverLateTime * 60;
                }
            }
            // 是否修改目的地
            if(isUpdateDest){
                lateTime += 3 * 60;
            }
        }
        if(arriveTime != null){
            return arriveTime > lateTime;
        } else {
            return nowTime > lateTime;
        }
    }

    public static void main(String[] args) {
        ComputeDriverLateTime computeDriverLateTime = new ComputeDriverLateTime();
        boolean is = computeDriverLateTime.isDriverLate(false,false,1L,1L,1L,1L,1L,false,"11");
    }
}
