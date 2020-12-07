package coding.work.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.math.BigDecimal;

import static trans_func.DetourFeatureHalfCircleAggData.getFeatureAggData;
import static trans_func.DetourFeatureHalfCircleDetailData.getDetourCircleFeature;
import static trans_func.DetourFeatureHalfCircleStrategyData.getDetourStragyData;


public class DetourFeatureHalfCircleJava {
    private static double EARTH_RADIUS = 6378.137;


    private static double rad(double d) {
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


    public static Map<String, Object> findCloseoint(Double lat, Double lng, Long index, List<String> geoPoints)
    {
        Double minDistance = 100000.0;
        Integer step = 0;
        Long minDistanceIndex = 0L;
        Boolean isContinue = true;
        Long i = index;

        while (i < geoPoints.size() && isContinue)
        {
            String geoPoint = geoPoints.get(i.intValue());
            if (geoPoint.split(",").length == 2)
            {
                String[] tmpGeo = geoPoint.split(",");
                Double lat1 = Double.valueOf(tmpGeo[1].replaceAll("\\.\\.\\.", "").replaceAll("\\.\\.", ""));
                Double lng1 = Double.valueOf(tmpGeo[0].replaceAll("\\.\\.\\.", "").replaceAll("\\.\\.", ""));
                Double distance = getDistance(lat, lng, lat1, lng1);
                if (distance <= minDistance)
                {
                    minDistance = distance;
                    minDistanceIndex = i;
                    step = 0;
                }
                else
                    step ++;

                if ((step >= 3 && minDistance < 150) || (step >= 3 && index > 0 && geoPoints.size() > 2000) || (step >= 3 && geoPoints.size() > 3000))
                    isContinue = false;
            }
            i ++;
        }
        // save as map and return
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("minDistanceIndex", minDistanceIndex);
        res.put("minDistance", minDistance);
        return res;
    }


    public static Map<String, Object> getGeoLatLng(List<String>geoPoints, Integer index)
    {
        String geoPoint = geoPoints.get(index);
        String[] startTmpGeo = geoPoint.split(",");
        Double geoLng = Double.valueOf(startTmpGeo[0]);
        Double geoLat = Double.valueOf(startTmpGeo[1]);
        // save and return
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("geoLng", geoLng);
        res.put("geoLat", geoLat);
        return res;
    }


    public static Map<String, Object> getTrueInfos(Double geoLng, Double geoLat, Long index, List<String> coordinates, Integer ergodicNumber)
    {
        Integer startIndex = -99;
        Integer endIndex = -99;

        if (ergodicNumber > 0)
        {
            if (index.intValue() >= coordinates.size())
                startIndex = coordinates.size() - 1;
            else
                startIndex = index.intValue();
        }
        else if (index.intValue() + ergodicNumber >= 0)
            startIndex = index.intValue() + ergodicNumber;
        else
            startIndex = 0;
        //
        if (ergodicNumber > 0)
        {
            if (index.intValue() + ergodicNumber < coordinates.size())
                endIndex = index.intValue() + ergodicNumber;
            else
                endIndex = coordinates.size() - 1;
        }
        else
            endIndex = index.intValue();
        //存放的是依次的距离之和。后一个点=前一个点+当前点的距离
        List<Double> distanceArr = new ArrayList<Double>();
        Integer shortestIndex = index.intValue();
        Double minDistance = Double.MAX_VALUE;
        Long tarTime = 0L;
        Double tarLat = 0.0;
        Double tarLng = 0.0;
        Integer begin = Integer.MAX_VALUE;
        Integer end = Integer.MIN_VALUE;
        //
        if (ergodicNumber < 0)
        {
            begin = endIndex;
            end = startIndex;
        }
        else
        {
            begin = startIndex;
            end = endIndex;
        }
        //
        ArrayList<Integer> arr = new ArrayList();
        if(ergodicNumber < 0)
        {
            for(int i = begin; i >= end; i--)
                arr.add(i);
        }
        else
        {
            for(int i = begin; i <= end; i++)
                arr.add(i);
        }
        //
        for(int i : arr)
        {
            String coordinate = coordinates.get(i);
            String[] coordinateArr = coordinate.split(",");
            Long timestamp = Long.valueOf(coordinateArr[0]);
            Double lat = Double.valueOf(coordinateArr[1]);
            Double lng = Double.valueOf(coordinateArr[2]);
            //
            Double tmpDistance = getDistance(geoLat, geoLng, lat, lng);
            if (tmpDistance < minDistance)
            {
                minDistance = tmpDistance;
                shortestIndex = i;
            }
            //第一个点的距离为0
            if (distanceArr.isEmpty())
                distanceArr.add(0.0);
            else
            {
                Double tmp1 = getDistance(lat, lng, tarLat, tarLng);
                Double tmp2 = distanceArr.get(distanceArr.size() - 1);
                distanceArr.add(tmp1 + tmp2);
            }
            tarTime = timestamp;
            tarLat = lat;
            tarLng = lng;
        }
        //得到真实路径中距离最近的点的相关信息
        String coordinate = coordinates.get(shortestIndex);
        String[] coordinateArr = coordinate.split(",");
        Long timestamp = Long.valueOf(coordinateArr[0]);
        Double lat = Double.valueOf(coordinateArr[1]);
        Double lng = Double.valueOf(coordinateArr[2]);
        //
        Integer idx = ergodicNumber>0 ? shortestIndex - startIndex : endIndex - shortestIndex;
        // save and return
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("minDistance", minDistance);    // Double
        res.put("timestamp", timestamp);        // Long
        res.put("lat", lat);                    // Double
        res.put("lng", lng);                    // Double
        res.put("shortestIndex", shortestIndex);// Integer
        res.put("startNewDistance", distanceArr.get(idx)); // Double
        return res;
    }


    public static HashMap<String, Object> FindHalfCircle(Long startTime, Long index1, Long index2, List<String> coordinates, List<String> geoPoints)
    {
        if (index1 != null)
        {
            Long startIndex = index1;
            Boolean isContinue = true;
            //
            startTime = 0L;
            Double startLat = 0.0;
            Double startLng = 0.0;
            Long endTime = 0L;
            Double endLat = 0.0;
            Double endLng = 0.0;
            //
            Double longStep = 0.0;
            Double lastLat = 0.0;
            Double lastLng = 0.0;
            Long start = 0L;
            Long end = 0L;
            Long indexRoutes = index2;
            Long startRoutesIndex = 0L;
            Long endRoutesIndex = 0L;

            while ((startIndex < coordinates.size()) && isContinue && (indexRoutes < geoPoints.size()))
            {
                // System.out.println("w2");
                String coordinate = coordinates.get(startIndex.intValue());
                String[] coordinateArray = coordinate.split(",");
                Long timeStamp = Long.valueOf(coordinateArray[0]);
                Double lat = Double.valueOf(coordinateArray[1]);
                Double lng = Double.valueOf(coordinateArray[2]);
                Double speed = Double.valueOf(coordinateArray[3]);
                Double direction = Double.valueOf(coordinateArray[4]);
                //寻找初始导航中最近的点
                Map<String, Object> res = findCloseoint(lat, lng, indexRoutes, geoPoints);
                Long minDistanceIndex = (Long) res.get("minDistanceIndex");
                Double minDistance = (Double) res.get("minDistance");
                indexRoutes = minDistanceIndex;
                // 以200m作为分界线
                if (minDistance > 200)
                {
                    if (startTime == 0)
                    {
                        startTime = timeStamp;
                        startLat = lat;
                        startLng = lng;
                        start = startIndex;
                        startRoutesIndex = minDistanceIndex;
                        longStep = 0.0;
                    }
                    else
                    {
                        // 分离后司机走的路径历程
                        longStep = longStep + getDistance(lastLat, lastLng, lat, lng);
                    }
                    lastLat = lat;
                    lastLng = lng;
                }
                else
                {
                    if (longStep < 100)
                    {
                        startTime = 0L;
                        startLat = 0.0;
                        startLng = 0.0;
                        longStep = 0.0;
                        lastLat = 0.0;
                        lastLng = 0.0;
                    }
                    else
                    {
                        endLat = lat;
                        endLng = lng;
                        longStep = longStep + getDistance(lastLat, lastLng, lat, lng);
                        endTime = timeStamp;
                        end = startIndex + 1;
                        endRoutesIndex = minDistanceIndex;
                        isContinue = false;
                    }

                }
                startIndex ++;
            }
            // save and return
            HashMap<String, Object> res2  = new HashMap<String, Object>();
            res2.put("startTime", startTime); // Long
            res2.put("startLat", startLat);   // Double
            res2.put("startLng", startLng);   // Double
            res2.put("endTime", endTime);     // Long
            res2.put("endLat", endLat);       // Double
            res2.put("endLng", endLng);       // Double
            res2.put("longStep", longStep);   // Double
            res2.put("start", start);         // Long
            res2.put("end", end);             // Long
            res2.put("startRoutesIndex", startRoutesIndex); // Long
            res2.put("endRoutesIndex", endRoutesIndex);     // Long
            return res2;
        } else
            return null;
    }


    public static Map<String, Object> adjustmentPointInformation(Double distance, Long startIndex, Long endIndex, Long startRoutes, Long endRoutes, List<String> coordinates, List<String> geoPoints)
    {
        //从规划路径中，目前的前后20个点。从真实路径起始的前50个点和终点的后50个点。mapping找到距离最短的点
        Long geoNum = 10L;
        Long geoStartStartIndex =  (startRoutes >= geoNum) ? startRoutes - geoNum : 0;
        Long geoStartEndIndex = ((startRoutes + geoNum) < geoPoints.size()) ? startRoutes + geoNum : geoPoints.size() - 1;
        Integer geoBestStartIndex = startRoutes.intValue();
        Double minAlgDistance = Double.MAX_VALUE;
        Long startTimestamp = 0L;
        Double startLat = 0.0;
        Double startLng = 0.0;
        Integer startBestIndex = 0;
        Double startDistance = 0.0;
        //
        for (Long i = geoStartStartIndex; i <= geoStartEndIndex; i++)
        {
            Map<String, Object> res = getGeoLatLng(geoPoints, i.intValue());
            Double geoNowLat = (Double) res.get("geoLat");
            Double geoNowLng = (Double) res.get("geoLng");
            // 获取最近点的相关信息
            Map<String, Object> res2 = getTrueInfos(geoNowLng, geoNowLat, startIndex, coordinates, -30);
            if (((Double) res2.get("minDistance")) < minAlgDistance)
            {
                minAlgDistance = (Double) res2.get("minDistance");
                geoBestStartIndex = i.intValue();
                startTimestamp = (Long) res2.get("timestamp");
                startLat = (Double) res2.get("lat");
                startLng = (Double) res2.get("lng");
                startBestIndex = (Integer) res2.get("shortestIndex");
                startDistance = (Double) res2.get("startNewDistance");
            }
        }
        // 针对结束点
        Long geoEndStartIndex = (endRoutes > geoNum) ? endRoutes - geoNum : 0;
        Long geoEndEndIndex = ((endRoutes + geoNum) < geoPoints.size()) ? endRoutes + geoNum : geoPoints.size() - 1;
        Integer geoBestEndIndex = endRoutes.intValue();
        minAlgDistance = Double.MAX_VALUE;
        Long endTimestamp = 0L;
        Double endLat = 0.0;
        Double endLng = 0.0;
        Integer endBestIndex = 0;
        Double endDistance = 0.0;
        //
        for (Long i = geoEndStartIndex; i <= geoEndEndIndex; i++)
        {
            Map<String, Object> res3 = getGeoLatLng(geoPoints, i.intValue());
            Double geoNowLat = (Double) res3.get("geoLat");
            Double geoNowLng = (Double) res3.get("geoLng");
            Map<String, Object> res4 = getTrueInfos(geoNowLng, geoNowLat, endIndex, coordinates, 30);
            if (((Double) res4.get("minDistance")) < minAlgDistance)
            {
                minAlgDistance = (Double) res4.get("minDistance");
                geoBestEndIndex = i.intValue();
                endTimestamp = (Long) res4.get("timestamp");
                endLat = (Double) res4.get("lat");
                endLng = (Double) res4.get("lng");
                endBestIndex = (Integer) res4.get("shortestIndex");
                endDistance = (Double) res4.get("startNewDistance");
            }
        }
        // save and return
        Map<String, Object> res5 = new HashMap<String, Object>();
        res5.put("startTimestamp", startTimestamp);                  // Long
        res5.put("startLat", startLat);                              // Double
        res5.put("startLng", startLng);                              // Double
        res5.put("endTimestamp", endTimestamp);                      // Long
        res5.put("endLat", endLat);                                  // Double
        res5.put("endLng", endLng);                                  // Double
        res5.put("distance", distance + startDistance + endDistance);// Double
        res5.put("startBestIndex", startBestIndex);                  // Integer
        res5.put("endBestIndex", endBestIndex);                      // Integer
        res5.put("geoBestStartIndex", geoBestStartIndex);            // Integer
        res5.put("geoBestEndIndex", geoBestEndIndex);                // Integer
        return res5;
    }


    public static JSONObject[] filterCoordinate(JSONArray points, Long start_time, Long end_time)
    {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int size = points.size();
        List<JSONObject> filter_info = new LinkedList();
        int i = 0;
        //过滤
        while(i<size)
        {
            JSONObject point = points.getJSONObject(i);
            Double speed = point.getDouble("speed");
            String createtime = point.getString("createtime");
            BigDecimal lat1 = point.getBigDecimal("lat");
            BigDecimal lon1 = point.getBigDecimal("lon");
            i += 1;
            //去掉空值
            if (createtime == null || lat1 == null || lon1 == null || speed == null)
                continue;
            //转换时间戳
            Date date = null;
            try
            {
                date = simpleDateFormat.parse(createtime);
            }
            catch (ParseException e)
            {
                continue;
            }
            //
            Long createtime_stamp = date.getTime() / 1000;
            //去掉不在时间段内的数据
            if ((createtime_stamp < start_time) || (createtime_stamp > end_time))
                continue;
            else
                filter_info.add(point);
        }
        if(filter_info.size()<1)
            return null;
        //排序
        Comparator comparator = new Comparator<JSONObject>()
        {
            public int compare(JSONObject p1,JSONObject p2)
            {
                String p1_speed = p1.getString("createtime");
                String p2_speed = p2.getString("createtime");
                Date date = null;
                try
                {
                    date = simpleDateFormat.parse(p1_speed);
                }
                catch (ParseException e)
                {
                    return 0;
                }
                Long now_time = date.getTime();
                try
                {
                    date = simpleDateFormat.parse(p2_speed);
                }
                catch (ParseException e)
                {
                    return 0;
                }
                Long last_time = date.getTime();
                if (now_time>last_time)
                    return 1;
                 else
                    return -1;
            }
        };
        JSONObject[] filters = filter_info.toArray(new JSONObject[filter_info.size()]);
        // 去掉排序步骤, 不然会报错
        // Arrays.sort(filters,comparator);
        return filters;
    }


    // 处理逻辑，如果有多条数据，取时间戳最小的那条数据
    private static String filterByStage(JSONArray string_geo_points_json, String order_stage)
    {
        Long timeStampMin = Long.MAX_VALUE;
        String geo_points = "";
        for(int i=0; i < string_geo_points_json.size(); i++)
        {
            JSONObject tmp_jo = string_geo_points_json.getJSONObject(i);
            // 原始数据为Long, total dataset 中为 String, 转译一下
            // Long timestmap = tmp_jo.getLong("timestamp");
            Long timestmap = 0L;
            // 兼容模式
            if(tmp_jo.containsKey("timestmap"))
                timestmap = tmp_jo.getLong("timestmap");
            else
                timestmap = tmp_jo.getLong("timestamp");


            String route_geo_points = tmp_jo.getString("route_geo_points");
            String stage = tmp_jo.getString("stage");
            if(stage.equals(order_stage))
            {
               if(timeStampMin > timestmap)
               {
                   timeStampMin = timestmap;
                   geo_points = route_geo_points;
               }
            }
        }
        return geo_points;
    }


    public static Long get_timestamp(String create_time)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(create_time);
        } catch (ParseException e) {
            return null;
        }
        Long driver_timestamp = date.getTime() / 1000;
        return driver_timestamp;
    }


    private static List<String> filter_geopoints(String[] geo_pionts)
    {
        List<String> res = new ArrayList<String>();
        for(int i=0; i<geo_pionts.length; i++){
            String geo_point = geo_pionts[i];
            String[] tmp_geo = geo_point.split(",");
            Integer tmp_geo_len = tmp_geo.length;
            if(tmp_geo_len.equals(2)){
                String lng1 = tmp_geo[0].replace("\\D", "");
                String lat1 = tmp_geo[1].replace("\\D", "");
                //
                if(!lng1.equals("") && !lat1.equals(""))
                    res.add(geo_point);
            }
        }
        return res;
    }

    public static double getLineAngle(double lat,double lng, double lat1,double lng1)
    {
        double mathPI = 3.1415926535897931;
        double tmpValue = 0;
        double latStart = lat * mathPI / 180;
        double lngStart = lng * mathPI / 180;
        double latEnd = lat1 * mathPI / 180;
        double lngEnd = lng1 * mathPI / 180;
        if (lng == lng1 || lat == lat1)
        {
            if (lng == lng1)
            {
                /// 经度相同
                if (lat1 >= lat)
                    return 0;
                else
                    return 180;
            }
            else
            {
                /// 纬度相同
                if (lng1 >= lng)
                    return 90;
                else
                    return 270;
            }
        }
        //
        tmpValue = Math.sin(latStart) * Math.sin(latEnd) + Math.cos(latStart) * Math.cos(latEnd) * Math.cos(lngEnd - lngStart);
        tmpValue = Math.sqrt(1 - tmpValue * tmpValue);
        tmpValue = Math.cos(latEnd) * Math.sin(lngEnd - lngStart) / tmpValue;
        double resultAngle = Math.abs(Math.asin(tmpValue) * 180 / mathPI);
        if (lng1 > lng)
        {
            if (lat1 >= lat)
                // 第一象限
                return resultAngle;
            else
                // 第二象限
                return 180 - resultAngle;
        }
        else
        {
            // 第四象限
            if (lat1 >= lat)
                return 360 - resultAngle;
            else
                // 第三象限
                return 180 + resultAngle;
        }
    }

    public static double getAngle(double lat,double lng, double lat1,double lng1,double lat2,double lng2, double lat3,double lng3)
    {
        double lastAngle = getLineAngle(lat, lng,lat1,lng1);
        double thisAngle = getLineAngle(lat2,lng2,lat3,lng3);
        double angle = Math.abs(thisAngle - lastAngle);
        if (angle > 180)
            angle = 360 - angle;
        return angle;
    }

    public static Map<String, Double> getPianyiCircle(Integer index1, Integer index2, Integer index3, Integer index4, List<String> coordinates, List<String>geoPoints)
    {
        Double lng = Double.valueOf(geoPoints.get(index3).split(",")[0]);
        Double lat = Double.valueOf(geoPoints.get(index3).split(",")[1]);
        Double lng1 = Double.valueOf(geoPoints.get(index4).split(",")[0]);
        Double lat1 = Double.valueOf(geoPoints.get(index4).split(",")[1]);
        Integer index = index1 + 1;
        Double bigAngleDistance = 0.0;
        Double maxAngle = 0.0;
        while (index < index2)
        {
            String nowPoint = coordinates.get(index);
            String lastPoint = coordinates.get(index - 1);
            String[] nowPointArr = nowPoint.split(",");
            String[] lastPointArr = lastPoint.split(",");
            Double nowLat = Double.valueOf(nowPointArr[1]);
            Double nowLng = Double.valueOf(nowPointArr[2]);
            Double lastLat = Double.valueOf(lastPointArr[1]);
            Double lastLng = Double.valueOf(lastPointArr[2]);
            Double diff_angle = getAngle(lastLat, lastLng, nowLat, nowLng, lat, lng, lat1, lng1);
            //
            if (maxAngle < diff_angle)
                maxAngle = diff_angle;
            //
            if (diff_angle > 90)
                bigAngleDistance += getDistance(lastLat, lastLng, nowLat, nowLng);
            //
            index ++;
        }
        // save and return
        Map<String, Double> res = new HashMap<String, Double>();
        res.put("bigAngleDistance", bigAngleDistance);
        res.put("maxAngle", maxAngle);
        return res;
    }


    public static Double getLineDistance(Integer start, Integer end, List<String> coordinate)
    {
        Integer index = start + 1;
        Double allDistance = 0.0;
        while (index <= end)
        {
            String[] nowPoint = coordinate.get(index).split(",");
            String[] lastPoint = coordinate.get(index - 1).split(",");
            // ??? lat lng 对调  1010 -> 0101
            Double distance = getDistance(Double.valueOf(lastPoint[1]),
                                          Double.valueOf(lastPoint[0]),
                                          Double.valueOf(nowPoint[1]),
                                          Double.valueOf(nowPoint[0]));
            allDistance += distance;
            index ++;
        }
        return allDistance;
    }


    private static String getRaoQuanResult(String order_stage, 
                                           Long begin_charge_time, 
                                           String coordinates_str, 
                                           String string_geo_points)
    /*
    参数:
    order_stage  中文名称:业务阶段 1代表送驾 0代表接驾  
    begin_charge_time   牛盾:begin_charge_time_s   牛盾中文:开始计费时间戳秒  
    coordinates_str  牛盾:driver_route_data 牛盾中文:地图轨迹返回数据
    string_geo_points 牛盾:qingdaohang_geo_points 牛盾中文:qingdaohang轨迹路径

    函数功能:
    根据导航路线和司机真实轨迹路线生成绕圈特征

    函数返回:
    中文: 绕圈轨迹特征  英文: raoquan_track_features
    */
    {
        // 边缘
        if(coordinates_str.equals("") || coordinates_str.equals("[]")  || null == coordinates_str)
            return null;
        if(null == order_stage || null == begin_charge_time)
            return null;
        if (null == string_geo_points)
            return null;
        //
        JSONArray string_geo_points_json = JSON.parseArray(string_geo_points);
        // 送驾段：会出现两种情况，一种是list中只有一条数据。一种是list中有多条数据。
        // 一条数据：属于正常的。
        // 多条数据：
        // 乘客改道，添加途经点等，不会导致送驾段出现两条数据，因为现在地图那边这块业务暂时不支持。但是这块逻辑需要备注在这里，用于后续的可能会对添加途经点等进行判责。
        // 有可能司机app重启，会造成首次请求会有超过一条记录。
        String begin_charge_geo_points = filterByStage(string_geo_points_json, order_stage);
        // 用于存放绕圈类的结果数据
        // 绕圈类的结果数据，可能存在多条，也就是存在多个圈，需要使用一个数组来存放
        JSONArray coordinates = JSON.parseArray(coordinates_str);
        JSONArray res_detour = new JSONArray();
        // 司机真实轨迹和导航路径都是有值的。
        if(coordinates.size() != 0 && string_geo_points_json.size() != 0 && begin_charge_geo_points != null)
        {
            int len = coordinates.size();
            JSONObject[] begin_charge_coordinates_json = filterCoordinate(coordinates, begin_charge_time,100000000000L);
            //
            if (null == begin_charge_coordinates_json)
                return null;
            //
            List<String> begin_charge_coordinates = new ArrayList<String>();
            for(int i = 0; i < begin_charge_coordinates_json.length; i++)
            {
                Long end_time = 100000000000L;
                JSONObject row = begin_charge_coordinates_json[i];
                String createtime = row.getString("createtime");
                Long timestamp = get_timestamp(createtime);
                Double lat = row.getDouble("lat");
                Double lon = row.getDouble("lon");
                Double speed = row.getDouble("speed");
                Double direction = -999.0; // 因为线上没有这个字段，这里赋值为-999
                //
                if(timestamp == null || lat == null || lon == null) {}
                else
                {
                    if(timestamp <= end_time && timestamp >= begin_charge_time)
                        begin_charge_coordinates.add(timestamp.toString()+ "," + lat.toString() + "," + lon.toString() + "," + speed.toString() + "," + direction.toString());
                }
            }
            String[] begin_charge_geo_points_array = begin_charge_geo_points.split(";");
            List<String> geo_points = filter_geopoints(begin_charge_geo_points_array);
            // 开始做特征匹配
            Long index1 = 0L;
            Long index2 = 0L;
            Boolean is_continue = true;
            //
            while(index1 < begin_charge_coordinates.size()-1 && is_continue)
            {
                HashMap<String, Object> find_half_Circle_hashmap = FindHalfCircle(0L,index1,index2,begin_charge_coordinates,geo_points);
                //
                Long end_time = (Long) find_half_Circle_hashmap.get("endTime");
                Double distance = (Double) find_half_Circle_hashmap.get("longStep");
                Long start_index = (Long) find_half_Circle_hashmap.get("start");
                Long index_routes = (Long) find_half_Circle_hashmap.get("end");
                Long start_routes = (Long) find_half_Circle_hashmap.get("startRoutesIndex");
                Long end_routes = (Long) find_half_Circle_hashmap.get("endRoutesIndex");
                //
                Map<String, Object> adjustment_point_information_hashmap = adjustmentPointInformation(distance, start_index, index_routes, start_routes, end_routes, begin_charge_coordinates, geo_points);
                Long start_time2 = (Long) adjustment_point_information_hashmap.get("startTimestamp");
                Double start_lat2 = (Double) adjustment_point_information_hashmap.get("startLat");
                Double start_lng2 = (Double) adjustment_point_information_hashmap.get("startLng");
                Long end_time2 = (Long) adjustment_point_information_hashmap.get("endTimestamp");
                Double end_lat2 = (Double) adjustment_point_information_hashmap.get("endLat");
                Double end_lng2 = (Double) adjustment_point_information_hashmap.get("endLng");
                Double distance2 = (Double) adjustment_point_information_hashmap.get("distance");
                Integer start_index2 = (Integer) adjustment_point_information_hashmap.get("startBestIndex");
                Integer index_routes2 = (Integer) adjustment_point_information_hashmap.get("endBestIndex");
                Integer start_routes2 = (Integer) adjustment_point_information_hashmap.get("geoBestStartIndex");
                Integer end_routes2 = (Integer) adjustment_point_information_hashmap.get("geoBestEndIndex");
                //
                if (end_time != 0)
                {
                    //开始进行偏移角计算
                    Map<String, Double> get_pianyi_circle_map = getPianyiCircle(start_index2, index_routes2, start_routes2, end_routes2, begin_charge_coordinates, geo_points);
                    Double big_angel_distance = get_pianyi_circle_map.get("bigAngleDistance");
                    Double max_angel = get_pianyi_circle_map.get("maxAngle");
                    //计算地图距离
                    Double geo_distance = getLineDistance(start_routes2, end_routes2, geo_points);
                    JSONObject detourbean = new JSONObject();
                    detourbean.put("charge_dis", distance2);
                    detourbean.put("geo_dis", geo_distance);
                    detourbean.put("diff_dis", distance2 - geo_distance);
                    detourbean.put("big_angel_dis", big_angel_distance);
                    detourbean.put("big_angel", max_angel);
                    detourbean.put("start_time", start_time2);
                    detourbean.put("start_lat", start_lat2);
                    detourbean.put("start_lng", start_lng2);
                    detourbean.put("end_time", end_time2);
                    detourbean.put("end_lat", end_lat2);
                    detourbean.put("end_lng", end_lng2);
                    detourbean.put("start_index", start_index2);
                    detourbean.put("end_index", index_routes2);
                    detourbean.put("start_routes", start_routes2);
                    detourbean.put("end_routes", end_routes2);
                    detourbean.put("order_stage", order_stage);
                    res_detour.add(detourbean);
                }
                else
                    is_continue = false;
                index1 = Long.valueOf(index_routes2);
                index2 = Long.valueOf(end_routes2);
            }
        }
        String res_str = null;
        try
        {
            res_str = new ObjectMapper().writeValueAsString(res_detour);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return res_str;
    }
}