package coding.work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-01 10:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class createRoutes {

    public static List<String> createRoutes(String driver_coordinate, String passenger_coordinate, Long start_time, Long end_time){
        if(driver_coordinate == null || passenger_coordinate == null || driver_coordinate.equals("") || passenger_coordinate.equals("") || driver_coordinate.equals("[]") || passenger_coordinate.equals("[]") ){
            return null;
        }
        JSONArray driver_points = JSON.parseArray(driver_coordinate);
        JSONArray passenger_points = JSON.parseArray(passenger_coordinate);
        int a = 0;
        int b = 0;
        boolean if_aend = false;
        LinkedList<String> routes = new LinkedList<>();
        JSONObject[] driver_sort = filter_coordinate(driver_points,start_time,end_time);
        JSONObject[] passenger_sort = filter_coordinate(passenger_points,start_time,end_time);
        if (null == passenger_sort || null == driver_sort){
            return null;
        }
        int passenger_len = passenger_sort.length;
        int driver_len = driver_sort.length;

        while(a<passenger_len && !if_aend){
            JSONObject passenger_point = passenger_sort[a];
            Long timestamp = get_timestamp(passenger_point.getString("createtime"));


            Double lon = passenger_point.getDouble("lon");
            Double lat = passenger_point.getDouble("lat");
            Double speed = passenger_point.getDouble("speed");
            Integer attributionType = passenger_point.getInteger("attributionType");
            if(attributionType != 1){
                a+=1;
                continue;
            }

            boolean if_end = false;
            JSONObject need_point = null;
            while(b<driver_len && !if_end){
                JSONObject driver_point = driver_sort[b];
                Long driver_timestamp = get_timestamp(driver_point.getString("createtime"));

                if(need_point == null) need_point = driver_point;
                Long diff_timestamp = driver_timestamp - timestamp;
                if(diff_timestamp > 0) {
                    if(diff_timestamp<Math.abs(get_timestamp(need_point.getString("createtime")) - timestamp)) need_point = driver_point;
                    if_end = true;
                    b = b-1;
                }else {
                    if(Math.abs(diff_timestamp)< Math.abs(get_timestamp(need_point.getString("createtime")) - timestamp))need_point = driver_point;
                }
                b+=1;
            }
            if(need_point == null) {
                if_aend = true;
            }else {
                if(b>=driver_len) if_aend = true;
                Long diff_time = Math.abs(get_timestamp(need_point.getString("createtime")) - timestamp);
                Double diff_dis = getDistance(need_point.getBigDecimal("lat"),need_point.getBigDecimal("lon"),BigDecimal.valueOf(lat), BigDecimal.valueOf(lon));
                if(diff_time<4) {
                    JSONObject res = new JSONObject();
                    res.put("diff_dis",diff_dis);
                    res.put("diff_time",diff_time);
                    res.put("server_timestamp",timestamp);
                    res.put("passenger_lat",lat);
                    res.put("passenger_lon",lon);
                    res.put("passenger_speed",speed);
                    res.put("driver_lat",need_point.getDouble("lat"));
                    res.put("driver_lon",need_point.getDouble("lon"));
                    res.put("driver_speed",need_point.getDouble("speed"));
                    routes.add(res.toJSONString());
                }
            }
            a+=1;
        }
        return routes;
    }

    public static Long get_timestamp(String create_time){
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

    public static double getDistance(BigDecimal lat1, BigDecimal lng1, BigDecimal lat2,
                                     BigDecimal lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378.137;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }
    public static double rad(BigDecimal d) {
        return d.doubleValue() * Math.PI / 180.0;
    }


    public static JSONObject[] filter_coordinate(JSONArray points,Long start_time,Long end_time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int size = points.size();
        List<JSONObject> filter_info = new LinkedList<>();
        int i = 0;
        //过滤
        while(i<size) {
            JSONObject point = points.getJSONObject(i);
            Double speed = point.getDouble("speed");
            String createtime = point.getString("createtime");
            BigDecimal lat1 = point.getBigDecimal("lat");
            BigDecimal lon1 = point.getBigDecimal("lon");
            i += 1;
            //去掉空值
            if (createtime == null || lat1 == null || lon1 == null || speed == null) continue;
            //转换时间戳
            Date date = null;
            try {
                date = simpleDateFormat.parse(createtime);
            } catch (ParseException e) {
                continue;
            }
            Long createtime_stamp = date.getTime() / 1000;
            //去掉不在时间段内的数据
            if ((createtime_stamp < start_time) || (createtime_stamp > end_time)) {
                continue;
            }
            else {
                filter_info.add(point);
            }
        }
        if(filter_info.size()<1) return null;
        //排序
        Comparator comparator = new Comparator<JSONObject>(){
            public int compare(JSONObject p1,JSONObject p2){
                String p1_speed = p1.getString("createtime");
                String p2_speed = p2.getString("createtime");
                Date date = null;
                try {
                    date = simpleDateFormat.parse(p1_speed);
                } catch (ParseException e) {
                    return 0;
                }
                Long now_time = date.getTime();
                try {
                    date = simpleDateFormat.parse(p2_speed);
                } catch (ParseException e) {
                    return 0;
                }
                Long last_time = date.getTime();
                if (now_time>last_time) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        //排序完成
        JSONObject[] filters = filter_info.toArray(new JSONObject[filter_info.size()]);
        Arrays.sort(filters,comparator);
        return filters;
    }

    public static void main(String[] args) {
        String driver_coordinate = "[{\"createtime\":\"2020-11-26 10:16:05\",\"lon\":\"-74.08836\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58091\",\"speed\":\"1.2797420024871826\"}, {\"createtime\":\"2020-11-26 10:16:06\",\"lon\":\"-74.08835\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.5809\",\"speed\":\"2.198976516723633\"}, {\"createtime\":\"2020-11-26 10:16:08\",\"lon\":\"-74.08833\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58087\",\"speed\":\"3.2041373252868652\"}, {\"createtime\":\"2020-11-26 10:16:09\",\"lon\":\"-74.08831\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58084\",\"speed\":\"3.367856025695801\"}, {\"createtime\":\"2020-11-26 10:16:10\",\"lon\":\"-74.08829\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58082\",\"speed\":\"3.7318880558013916\"}, {\"createtime\":\"2020-11-26 10:16:12\",\"lon\":\"-74.08826\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58074\",\"speed\":\"4.04752254486084\"}, {\"createtime\":\"2020-11-26 10:16:13\",\"lon\":\"-74.08826\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58069\",\"speed\":\"3.948085069656372\"}, {\"createtime\":\"2020-11-26 10:16:15\",\"lon\":\"-74.08829\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58063\",\"speed\":\"5.0644211769104\"}, {\"createtime\":\"2020-11-26 10:16:17\",\"lon\":\"-74.08838\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58054\",\"speed\":\"6.800811767578125\"}, {\"createtime\":\"2020-11-26 10:16:19\",\"lon\":\"-74.08849\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58043\",\"speed\":\"6.93803071975708\"}, {\"createtime\":\"2020-11-26 10:16:20\",\"lon\":\"-74.08855\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58038\",\"speed\":\"7.5900044441223145\"}, {\"createtime\":\"2020-11-26 10:16:22\",\"lon\":\"-74.08867\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58028\",\"speed\":\"7.910764694213867\"}, {\"createtime\":\"2020-11-26 10:16:23\",\"lon\":\"-74.08872\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58024\",\"speed\":\"7.865994930267334\"}, {\"createtime\":\"2020-11-26 10:16:25\",\"lon\":\"-74.08884\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58015\",\"speed\":\"7.924576282501221\"}, {\"createtime\":\"2020-11-26 10:16:26\",\"lon\":\"-74.08889\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58011\",\"speed\":\"8.136524200439453\"}, {\"createtime\":\"2020-11-26 10:16:28\",\"lon\":\"-74.089\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.58002\",\"speed\":\"7.941721439361572\"}, {\"createtime\":\"2020-11-26 10:16:30\",\"lon\":\"-74.08909\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57993\",\"speed\":\"5.005725860595703\"}, {\"createtime\":\"2020-11-26 10:16:32\",\"lon\":\"-74.08914\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57989\",\"speed\":\"3.5335750579833984\"}, {\"createtime\":\"2020-11-26 10:16:34\",\"lon\":\"-74.08916\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57987\",\"speed\":\"2.7800424098968506\"}, {\"createtime\":\"2020-11-26 10:16:35\",\"lon\":\"-74.08918\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57985\",\"speed\":\"2.982139825820923\"}, {\"createtime\":\"2020-11-26 10:16:37\",\"lon\":\"-74.08921\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57982\",\"speed\":\"4.367158889770508\"}, {\"createtime\":\"2020-11-26 10:16:38\",\"lon\":\"-74.08923\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57979\",\"speed\":\"5.362079620361328\"}, {\"createtime\":\"2020-11-26 10:16:40\",\"lon\":\"-74.08931\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57969\",\"speed\":\"7.238584995269775\"}, {\"createtime\":\"2020-11-26 10:16:41\",\"lon\":\"-74.08937\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57962\",\"speed\":\"5.8815412521362305\"}, {\"createtime\":\"2020-11-26 10:16:42\",\"lon\":\"-74.08941\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57956\",\"speed\":\"7.761025905609131\"}, {\"createtime\":\"2020-11-26 10:16:44\",\"lon\":\"-74.0895\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57942\",\"speed\":\"9.577754020690918\"}, {\"createtime\":\"2020-11-26 10:16:45\",\"lon\":\"-74.08955\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57934\",\"speed\":\"10.212401390075684\"}, {\"createtime\":\"2020-11-26 10:16:46\",\"lon\":\"-74.0896\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57925\",\"speed\":\"10.537979125976562\"}, {\"createtime\":\"2020-11-26 10:16:48\",\"lon\":\"-74.0897\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57909\",\"speed\":\"10.47835636138916\"}, {\"createtime\":\"2020-11-26 10:16:49\",\"lon\":\"-74.08975\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57901\",\"speed\":\"10.229930877685547\"}, {\"createtime\":\"2020-11-26 10:16:51\",\"lon\":\"-74.08984\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57886\",\"speed\":\"9.518263816833496\"}, {\"createtime\":\"2020-11-26 10:16:53\",\"lon\":\"-74.08992\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57873\",\"speed\":\"8.718290328979492\"}, {\"createtime\":\"2020-11-26 10:16:55\",\"lon\":\"-74.08998\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57861\",\"speed\":\"7.618375301361084\"}, {\"createtime\":\"2020-11-26 10:16:56\",\"lon\":\"-74.09\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57856\",\"speed\":\"7.26140022277832\"}, {\"createtime\":\"2020-11-26 10:16:58\",\"lon\":\"-74.09005\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57845\",\"speed\":\"6.798025131225586\"}, {\"createtime\":\"2020-11-26 10:17:00\",\"lon\":\"-74.09009\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57836\",\"speed\":\"6.363475322723389\"}, {\"createtime\":\"2020-11-26 10:17:01\",\"lon\":\"-74.09012\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57831\",\"speed\":\"6.60490083694458\"}, {\"createtime\":\"2020-11-26 10:17:03\",\"lon\":\"-74.09017\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.5782\",\"speed\":\"7.07977294921875\"}, {\"createtime\":\"2020-11-26 10:17:05\",\"lon\":\"-74.09023\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57808\",\"speed\":\"6.720795631408691\"}, {\"createtime\":\"2020-11-26 10:17:07\",\"lon\":\"-74.09029\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57797\",\"speed\":\"6.799284934997559\"}, {\"createtime\":\"2020-11-26 10:17:08\",\"lon\":\"-74.09032\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57791\",\"speed\":\"6.882282257080078\"}, {\"createtime\":\"2020-11-26 10:17:10\",\"lon\":\"-74.09038\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57779\",\"speed\":\"6.730239391326904\"}, {\"createtime\":\"2020-11-26 10:17:11\",\"lon\":\"-74.09041\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57773\",\"speed\":\"6.556800842285156\"}, {\"createtime\":\"2020-11-26 10:17:13\",\"lon\":\"-74.09046\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57763\",\"speed\":\"6.599545001983643\"}, {\"createtime\":\"2020-11-26 10:17:14\",\"lon\":\"-74.09049\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57758\",\"speed\":\"6.809155464172363\"}, {\"createtime\":\"2020-11-26 10:17:16\",\"lon\":\"-74.09054\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57746\",\"speed\":\"6.897576808929443\"}, {\"createtime\":\"2020-11-26 10:17:18\",\"lon\":\"-74.09058\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57735\",\"speed\":\"5.556490421295166\"}, {\"createtime\":\"2020-11-26 10:17:20\",\"lon\":\"-74.09062\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57727\",\"speed\":\"3.2596445083618164\"}, {\"createtime\":\"2020-11-26 10:17:21\",\"lon\":\"-74.09063\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57725\",\"speed\":\"1.9188649654388428\"}, {\"createtime\":\"2020-11-26 10:17:23\",\"lon\":\"-74.09063\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57724\",\"speed\":\"0.3604731261730194\"}, {\"createtime\":\"2020-11-26 10:17:24\",\"lon\":\"-74.09063\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57724\",\"speed\":\"0.01788819022476673\"}, {\"createtime\":\"2020-11-26 10:17:26\",\"lon\":\"-74.09063\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57725\",\"speed\":\"0.00002932243114628363\"}, {\"createtime\":\"2020-11-26 10:17:28\",\"lon\":\"-74.09063\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57724\",\"speed\":\"2.372431755065918\"}, {\"createtime\":\"2020-11-26 10:17:29\",\"lon\":\"-74.09064\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57722\",\"speed\":\"2.901578187942505\"}, {\"createtime\":\"2020-11-26 10:17:31\",\"lon\":\"-74.09066\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57718\",\"speed\":\"3.127917528152466\"}, {\"createtime\":\"2020-11-26 10:17:32\",\"lon\":\"-74.09068\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57716\",\"speed\":\"3.336853265762329\"}, {\"createtime\":\"2020-11-26 10:17:33\",\"lon\":\"-74.09069\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57713\",\"speed\":\"3.671717882156372\"}, {\"createtime\":\"2020-11-26 10:17:35\",\"lon\":\"-74.0907\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57705\",\"speed\":\"3.507920265197754\"}, {\"createtime\":\"2020-11-26 10:17:37\",\"lon\":\"-74.09067\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57697\",\"speed\":\"4.409945964813232\"}, {\"createtime\":\"2020-11-26 10:17:38\",\"lon\":\"-74.09065\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57695\",\"speed\":\"4.370636940002441\"}, {\"createtime\":\"2020-11-26 10:17:40\",\"lon\":\"-74.09057\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.5769\",\"speed\":\"5.3975701332092285\"}, {\"createtime\":\"2020-11-26 10:17:42\",\"lon\":\"-74.09047\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57684\",\"speed\":\"6.094685077667236\"}, {\"createtime\":\"2020-11-26 10:17:44\",\"lon\":\"-74.09036\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57677\",\"speed\":\"7.592569828033447\"}, {\"createtime\":\"2020-11-26 10:17:46\",\"lon\":\"-74.09022\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57668\",\"speed\":\"9.102367401123047\"}, {\"createtime\":\"2020-11-26 10:17:47\",\"lon\":\"-74.09015\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57663\",\"speed\":\"9.708749771118164\"}, {\"createtime\":\"2020-11-26 10:17:49\",\"lon\":\"-74.08999\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57654\",\"speed\":\"10.1257963180542\"}, {\"createtime\":\"2020-11-26 10:17:50\",\"lon\":\"-74.08991\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57649\",\"speed\":\"10.184078216552734\"}, {\"createtime\":\"2020-11-26 10:17:51\",\"lon\":\"-74.08983\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57644\",\"speed\":\"10.113137245178223\"}, {\"createtime\":\"2020-11-26 10:17:53\",\"lon\":\"-74.08968\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57635\",\"speed\":\"9.438055038452148\"}, {\"createtime\":\"2020-11-26 10:17:54\",\"lon\":\"-74.08962\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57631\",\"speed\":\"8.874238014221191\"}, {\"createtime\":\"2020-11-26 10:17:56\",\"lon\":\"-74.0895\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57623\",\"speed\":\"7.612854957580566\"}, {\"createtime\":\"2020-11-26 10:17:57\",\"lon\":\"-74.08945\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57619\",\"speed\":\"6.846209526062012\"}, {\"createtime\":\"2020-11-26 10:17:59\",\"lon\":\"-74.08937\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57614\",\"speed\":\"4.8059773445129395\"}, {\"createtime\":\"2020-11-26 10:18:00\",\"lon\":\"-74.08934\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57612\",\"speed\":\"3.448986530303955\"}, {\"createtime\":\"2020-11-26 10:18:02\",\"lon\":\"-74.08932\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57611\",\"speed\":\"0.08945263922214508\"}, {\"createtime\":\"2020-11-26 10:18:04\",\"lon\":\"-74.08932\",\"attributionType\":-1,\"local_time64_gps\":-1,\"lat\":\"4.57611\",\"speed\":\"0.027995390817523003\"}]";
        String passenger_coordinate = "[{\"createtime\":\"2020-11-26 10:16:12\",\"lon\":\"-74.0883316\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5808541\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:16:22\",\"lon\":\"-74.088537\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5804901\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:16:32\",\"lon\":\"-74.0891232\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5799401\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:16:42\",\"lon\":\"-74.0893546\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5796254\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:16:52\",\"lon\":\"-74.0898318\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5789065\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:02\",\"lon\":\"-74.0900905\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5783134\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:13\",\"lon\":\"-74.0904548\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.577703\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:23\",\"lon\":\"-74.0906704\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5772685\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:33\",\"lon\":\"-74.0906704\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5772685\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:43\",\"lon\":\"-74.0904151\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5768231\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:17:57\",\"lon\":\"-74.0895254\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.5761655\",\"speed\":\"-1\"}, {\"createtime\":\"2020-11-26 10:18:03\",\"lon\":\"-74.0893729\",\"attributionType\":0,\"local_time64_gps\":-1,\"lat\":\"4.576111\",\"speed\":\"-1\"}]";
        Long start_time = 1606356964L;
        Long end_time = 1606357084L;
        System.out.println(createRoutes(driver_coordinate,passenger_coordinate,start_time,end_time));
    }
}
