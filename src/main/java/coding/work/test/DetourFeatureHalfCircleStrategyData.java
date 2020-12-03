package coding.work.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetourFeatureHalfCircleStrategyData
{
    private static JSONArray getDetourFeatureHalfCircleStrategyData(BigDecimal speed_limit, BigDecimal qidian_dis_limit, BigDecimal zhongdian_dis_limit, JSONArray raoquanFeature) {
        if(null == speed_limit || null == qidian_dis_limit || null == zhongdian_dis_limit || null == raoquanFeature)
            return null;

        JSONArray res = new JSONArray();
        Double tar_charge_dis = 0.0;
        Double tar_geo_dis = 0.0;
        Double tar_diff_dis = 0.0;
        Double tar_big_angel_dis = 0.0;
        Double tar_big_angel = 0.0;
        int tar_raoquan_index = 0;

        for(int i=0; i<raoquanFeature.size(); i++)
        {
            JSONObject res_tmp = new JSONObject();

            JSONObject tmp = raoquanFeature.getJSONObject(i);
            Long start_time = tmp.getLong("start_time");
            Long end_time = tmp.getLong("end_time");
            Double charge_dis = tmp.getDouble("charge_dis");
            Double diff_dis = tmp.getDouble("diff_dis");
            Double geo_dis = tmp.getDouble("geo_dis");
            Double big_angel_dis = tmp.getDouble("big_angel_dis");
            Double big_angel = tmp.getDouble("big_angel");
            Double raoquan_end_start_diff_dis = tmp.getDouble("raoquan_end_start_diff_dis");
            Double raoquan_begin_dest_diff_dis = tmp.getDouble("raoquan_begin_dest_diff_dis");

            if(start_time < end_time && charge_dis /(end_time - start_time + 1) <= Double.parseDouble(String.valueOf(speed_limit)) && diff_dis /(end_time - start_time + 1) <= Double.parseDouble(String.valueOf(speed_limit)))
            {
                int raoquan_index_qidian = 0;
                int raoquan_index_zhongtu = 0;
                int raoquan_index_zhongdian = 0;
                if(raoquan_end_start_diff_dis <= Double.parseDouble(String.valueOf(qidian_dis_limit)))
                    raoquan_index_qidian = 1;
                
                if(raoquan_end_start_diff_dis > Double.parseDouble(String.valueOf(qidian_dis_limit)) && raoquan_begin_dest_diff_dis > Double.parseDouble(String.valueOf(zhongdian_dis_limit)))
                    raoquan_index_zhongtu = 2;

                if(raoquan_begin_dest_diff_dis <= Double.parseDouble(String.valueOf(zhongdian_dis_limit)))
                    raoquan_index_zhongdian = 4;
                

                if(diff_dis > tar_diff_dis)
                {
                    tar_charge_dis = charge_dis;
                    tar_geo_dis = geo_dis;
                    tar_diff_dis = diff_dis;
                    tar_big_angel_dis = big_angel_dis;
                    tar_big_angel = big_angel;
                    tar_raoquan_index = raoquan_index_qidian + raoquan_index_zhongtu + raoquan_index_zhongdian;;
                }

                res_tmp.put("raoquan_charge_dis", tar_charge_dis);
                res_tmp.put("raoquan_geo_dis", tar_geo_dis);
                res_tmp.put("raoquan_diff_dis", tar_diff_dis);
                res_tmp.put("raoquan_big_angel_dis", tar_big_angel_dis);
                res_tmp.put("raoquan_big_angel", tar_big_angel);
                res_tmp.put("raoquan_index", tar_raoquan_index);
                res.add(res_tmp);
            }
            else
                continue;
        }

        if (res.size() > 0)
            return res;
        else
            return null;
    }
}
