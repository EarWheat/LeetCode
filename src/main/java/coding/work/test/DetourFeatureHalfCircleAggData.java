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
import java.util.zip.DeflaterOutputStream;


public class DetourFeatureHalfCircleAggData
{
    public static JSONArray getDetourFeatureHalfCircleAggData(BigDecimal dis_begin_charge_to_starting,
                                                              Long eda_trip_long,
                                                              BigDecimal dis_dest_to_finish,
                                                              BigDecimal qidian_max_dis,
                                                              BigDecimal qidian_min_dis,
                                                              BigDecimal qidian_ratio,
                                                              BigDecimal zhongdian_max_dis,
                                                              BigDecimal zhongdian_min_dis,
                                                              BigDecimal zhongdian_ratio,
                                                              BigDecimal zhongtu_max_dis,
                                                              BigDecimal zhongtu_min_dis,
                                                              BigDecimal zhongtu_ratio,
                                                              JSONArray raoquanFeature)
    {
        if(null == dis_begin_charge_to_starting || null == eda_trip_long || null == dis_dest_to_finish)
            return  null;

        JSONObject res = new JSONObject();
        JSONArray res_arr = new JSONArray();
        Long qidian_label = -1L;
        Long zhongdian_label = -1L;
        Long zhongtu_label = -1L;
        Double qidian_ratio_real = Double.parseDouble(String.valueOf(dis_begin_charge_to_starting)) / eda_trip_long;
        
        // 起点
        if(dis_begin_charge_to_starting.compareTo(qidian_max_dis) > 0 || (dis_begin_charge_to_starting.compareTo(qidian_min_dis)>0 && qidian_ratio_real > Double.parseDouble(String.valueOf(qidian_ratio))))
        {
            qidian_label = 1L;
        }
        else
            qidian_label = 0L;

        // 终点
        Double zhongdian_ratio_real = Double.parseDouble(String.valueOf(dis_dest_to_finish)) / eda_trip_long;
        if(dis_dest_to_finish.compareTo(zhongdian_max_dis)>0 || (dis_dest_to_finish.compareTo(zhongdian_min_dis)>0 && zhongdian_ratio_real>Double.parseDouble(String.valueOf(zhongdian_ratio))))
        {
            zhongdian_label = 1L;
        }
        else
            zhongdian_label = 0L;

        // 中途
        Double sum_raoquan_diff_dis = 0.0;
        Double max_raoquan_diff_dis = 0.0;
        //
        for(int i=0; i<raoquanFeature.size(); i++)
        {
            JSONObject tmp = raoquanFeature.getJSONObject(i);
            Double raoquan_diff_dis = tmp.getDouble("diff_dis");
            sum_raoquan_diff_dis += raoquan_diff_dis;
            max_raoquan_diff_dis = max_raoquan_diff_dis > raoquan_diff_dis ? max_raoquan_diff_dis:raoquan_diff_dis;
        }
        Double zhongtu_ratio_sum_real = sum_raoquan_diff_dis/eda_trip_long;
        Double zhongtu_ratio_max_real = max_raoquan_diff_dis/eda_trip_long;
        //
        if(sum_raoquan_diff_dis>Double.parseDouble(String.valueOf(zhongtu_max_dis))
        || (sum_raoquan_diff_dis> Double.parseDouble(String.valueOf(zhongtu_min_dis)) && zhongtu_ratio_sum_real >Double.parseDouble(String.valueOf(zhongtu_ratio)))
        || max_raoquan_diff_dis > Double.parseDouble(String.valueOf(zhongtu_max_dis))
        || (max_raoquan_diff_dis>Double.parseDouble(String.valueOf(zhongtu_min_dis)) && zhongtu_ratio_max_real>Double.parseDouble(String.valueOf(zhongtu_ratio))))
        {
            zhongtu_label = 1L;
        }else
            zhongtu_label = 0L;
        //
        res.put("qidian_label", qidian_label);
        res.put("zhongtu_label", zhongtu_label);
        res.put("zhongdian_label", zhongdian_label);
        //
        res.put("qidian_ratio_real", qidian_ratio_real);
        res.put("zhongdian_ratio_real", zhongdian_ratio_real);
        res.put("zhongtu_ratio_sum_real", zhongtu_ratio_sum_real);
        res.put("zhongtu_ratio_max_real", zhongtu_ratio_max_real);
        //
        res_arr.add(res);
        return res_arr;
    }
}
