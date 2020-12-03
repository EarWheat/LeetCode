package coding.work.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetourFeatureHalfCircleDetailData
{
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) 
    {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
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
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    public static JSONArray getDetourFeatureHalfCircleDetailData(Long start_time,
                                                                 Long end_time,
                                                                 BigDecimal starting_lng,
                                                                 BigDecimal starting_lat,
                                                                 BigDecimal dest_lng,
                                                                 BigDecimal dest_lat,
                                                                 JSONArray circleFeature)
    {
        if(null == circleFeature)
            return null;
        //
        JSONArray res = new JSONArray();
        //
        for(int i=0; i<circleFeature.size(); i++)
        {
            JSONObject tmp = circleFeature.getJSONObject(i);
            Long raoquan_start_time = tmp.getLong("start_time");
            Double raoquan_start_lat = tmp.getDouble("start_lat");
            Double raoquan_start_lng = tmp.getDouble("start_lng");
            Long raoquan_end_time = tmp.getLong("end_time");
            Double raoquan_end_lat = tmp.getDouble("end_lat");
            Double raoquan_end_lng = tmp.getDouble("end_lng");
            //
            Long raoquan_begin_start_diff_time = raoquan_start_time - start_time;
            Long raoquan_begin_dest_diff_time = end_time - raoquan_start_time;
            Long raoquan_end_start_diff_time = raoquan_end_time - start_time;
            Long raoquan_end_dest_diff_time = end_time - raoquan_end_time;
            Double raoquan_begin_start_diff_dis = getDistance(raoquan_start_lat, raoquan_start_lng, Double.parseDouble(String.valueOf(starting_lat)), Double.parseDouble(String.valueOf(starting_lng)));
            Double raoquan_begin_dest_diff_dis = getDistance(raoquan_start_lat, raoquan_start_lng, Double.parseDouble(String.valueOf(dest_lat)), Double.parseDouble(String.valueOf(dest_lng)));
            Double raoquan_end_start_diff_dis = getDistance(raoquan_end_lat, raoquan_end_lng, Double.parseDouble(String.valueOf(starting_lat)), Double.parseDouble(String.valueOf(starting_lng)));
            Double raoquan_end_dest_diff_dis = getDistance(raoquan_end_lat, raoquan_end_lng, Double.parseDouble(String.valueOf(dest_lat)), Double.parseDouble(String.valueOf(dest_lng)));
            //
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
        return res;
    }
}
