package coding.work.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

public class DetourFeatureHalfCircleDetailData {

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        /**
         * 通过经纬度获取距离(单位：米)
         *
         * @param lat1
         * @param lng1
         * @param lat2
         * @param lng2
         * @return 距离
         */
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        double EARTH_RADIUS = 6378.137;
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    /*
    参数:
    start_time         牛盾中文:开始计费时间戳秒  牛盾:begin_charge_time_s
    end_time           牛盾中文:订单完成时间戳秒  牛盾:finish_time_s
    starting_lng       起点经度    starting_lng
    starting_lat       起点纬度    starting_lat
    dest_lng           终点经度    dest_lng
    dest_lat           终点纬度    dest_lat
    circleFeature_str  绕圈轨迹特征   raoquan_track_features

    函数功能:
    增加轨迹绕圈类特征数据

    函数返回:
    中文: 绕圈轨迹特征_新增  英文: raoquan_track_features_update
 */
    public static String getDetourFeatureHalfCircleDetailData(Long start_time,
                                                              Long end_time,
                                                              BigDecimal starting_lng,
                                                              BigDecimal starting_lat,
                                                              BigDecimal dest_lng,
                                                              BigDecimal dest_lat,
                                                              String circleFeature_str) {
        if (StringUtils.isBlank(circleFeature_str))
            return null;
        JSONArray circleFeature = JSON.parseArray(circleFeature_str);
        JSONArray res = new JSONArray();
        for (int i = 0; i < circleFeature.size(); i++) {
            JSONObject tmp = circleFeature.getJSONObject(i);
            Long raoquan_start_time = tmp.getLong("start_time");
            Double raoquan_start_lat = tmp.getDouble("start_lat");
            Double raoquan_start_lng = tmp.getDouble("start_lng");
            Long raoquan_end_time = tmp.getLong("end_time");
            Double raoquan_end_lat = tmp.getDouble("end_lat");
            Double raoquan_end_lng = tmp.getDouble("end_lng");

            Long raoquan_begin_start_diff_time = raoquan_start_time - start_time;
            Long raoquan_begin_dest_diff_time = end_time - raoquan_start_time;
            Long raoquan_end_start_diff_time = raoquan_end_time - start_time;
            Long raoquan_end_dest_diff_time = end_time - raoquan_end_time;
            Double raoquan_begin_start_diff_dis = getDistance(raoquan_start_lat, raoquan_start_lng, Double.parseDouble(String.valueOf(starting_lat)), Double.parseDouble(String.valueOf(starting_lng)));
            Double raoquan_begin_dest_diff_dis = getDistance(raoquan_start_lat, raoquan_start_lng, Double.parseDouble(String.valueOf(dest_lat)), Double.parseDouble(String.valueOf(dest_lng)));
            Double raoquan_end_start_diff_dis = getDistance(raoquan_end_lat, raoquan_end_lng, Double.parseDouble(String.valueOf(starting_lat)), Double.parseDouble(String.valueOf(starting_lng)));
            Double raoquan_end_dest_diff_dis = getDistance(raoquan_end_lat, raoquan_end_lng, Double.parseDouble(String.valueOf(dest_lat)), Double.parseDouble(String.valueOf(dest_lng)));

            tmp.put("raoquan_begin_start_diff_time", raoquan_begin_start_diff_time);
            tmp.put("raoquan_begin_dest_diff_time", raoquan_begin_dest_diff_time);
            tmp.put("raoquan_end_start_diff_time", raoquan_end_start_diff_time);
            tmp.put("raoquan_end_dest_diff_time", raoquan_end_dest_diff_time);
            tmp.put("raoquan_begin_start_diff_dis", raoquan_begin_start_diff_dis);
            tmp.put("raoquan_begin_dest_diff_dis", raoquan_begin_dest_diff_dis);
            tmp.put("raoquan_end_start_diff_dis", raoquan_end_start_diff_dis);
            tmp.put("raoquan_end_dest_diff_dis", raoquan_end_dest_diff_dis);

            res.add(tmp);
        }
        return JSONObject.toJSONString(res);
    }

    public static void main(String[] args) {
        Long startTime = 1606000398L;
        Long endTime = 1606005772L;
        BigDecimal startLng = new BigDecimal(-38.60265);
        BigDecimal startLat = new BigDecimal(-3.76966);
        BigDecimal dest_lng = new BigDecimal(-38.6028);
        BigDecimal dest_lat = new BigDecimal(-3.76937);
        String circleFeature_str = "[{\"big_angel_dis\":73.59999999999998,\"end_lat\":-3.77026,\"geo_dis\":670.8,\"charge_dis\":158.69999999999993,\"diff_dis\":-512.1,\"end_time\":1606000722,\"start_routes\":795,\"end_index\":202,\"end_routes\":827,\"order_stage\":\"4\",\"start_time\":1606000529,\"start_lng\":-38.60204,\"big_angel\":155.95013482050524,\"start_index\":80,\"start_lat\":-3.77097,\"end_lng\":-38.60145},{\"big_angel_dis\":257.7,\"end_lat\":-3.76905,\"geo_dis\":0.0,\"charge_dis\":515.8,\"diff_dis\":515.8,\"end_time\":1606001642,\"start_routes\":827,\"end_index\":783,\"end_routes\":827,\"order_stage\":\"4\",\"start_time\":1606001532,\"start_lng\":-38.60189,\"big_angel\":168.7134652869604,\"start_index\":716,\"start_lat\":-3.76925,\"end_lng\":-38.60246},{\"big_angel_dis\":11453.000000000018,\"end_lat\":-3.76817,\"geo_dis\":25.8,\"charge_dis\":24472.30000000016,\"diff_dis\":24446.50000000016,\"end_time\":1606005737,\"start_routes\":824,\"end_index\":3343,\"end_routes\":826,\"order_stage\":\"4\",\"start_time\":1606001676,\"start_lng\":-38.60302,\"big_angel\":178.6790043128642,\"start_index\":803,\"start_lat\":-3.76782,\"end_lng\":-38.60328}]";
        System.out.println(getDetourFeatureHalfCircleDetailData(startTime,endTime,startLng,startLat,dest_lng,dest_lat,circleFeature_str));
    }
}
