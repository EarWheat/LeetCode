package coding.work;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-03 10:45
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class queryFromEs {
    public static String makeESDosQueryParamWithDate(Long indexRange, Long driverId, Long pageSize,String startTime, String endTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("indexRange", indexRange);
        Map<String, Object> filterParams = new HashMap<>();
        filterParams.put("order_base.driver_id", driverId);
        map.put("filterParams", filterParams);
        map.put("withPageInfo", true);
        map.put("pageNo", 1);
        map.put("pageSize", pageSize);
        map.put("withSorting", true);
        map.put("sortingField", "order_base._create_time");
        map.put("desc", true);
        map.put("connectionTimeout", 5000);
        ArrayList<String> fieldList = new ArrayList<>();
        fieldList.add("order_base.order_id");
        map.put("field",fieldList);
        Map<String, Map<String, Object>> rangeConditions = new HashMap<>();
        Map<String, Object> dateMap = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        if(endTime.equals("0000-00-00 00:00:00")){
            endTime = simpleDateFormat.format(date.getTime());
        }
        if(startTime.equals("0000-00-00 00:00:00")){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH,-12);
            startTime = simpleDateFormat.format(calendar.getTime());
        }
        dateMap.put("gte",startTime);
        dateMap.put("lte",endTime);
        rangeConditions.put("order_base._create_time",dateMap);
        map.put("rangeConditions", rangeConditions);
        return JSON.toJSONString(map);
    }

    public static void main(String[] args) {
        System.out.println(makeESDosQueryParamWithDate(-12L,123456L,300L,"0000-00-00 00:00:00","0000-00-00 00:00:00"));
    }
}
