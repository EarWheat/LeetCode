package coding.work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-30 10:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class filterOriRoutes {
    public static List<String> filter_ori_routes(List<String> ori_routes, Long start_time, Long end_time ,Long diff_time, BigDecimal diff_dis){
        List filter_ori_routes = new ArrayList<String>();
        if(ori_routes == null || ori_routes.size() == 0){
            return ori_routes;
        }
        int start = -1;
        int end = -1;
        for(int i = 0 ; i< ori_routes.size(); i+=1){
            String route = ori_routes.get(i);
            JSONObject object = JSON.parseObject(route);
            Long server_timestamp = object.getLong("server_timestamp");
            Long diff_time_ori = object.getLong("diff_time");
            double diff_dis_ori = object.getDouble("diff_dis");
            if(server_timestamp>end_time) break;

            double diff_dis_double = Double.parseDouble(diff_dis.toString());
            if(server_timestamp>= start_time){
                if(diff_dis_double >= 0 && diff_dis_double < diff_dis_ori) continue;
                if(diff_time >= 0 && diff_time < diff_time_ori) continue;
                filter_ori_routes.add(route);
            }
        }
        return filter_ori_routes;
    }

}
