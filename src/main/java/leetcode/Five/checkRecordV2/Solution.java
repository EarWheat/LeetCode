package leetcode.Five.checkRecordV2;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/18 6:07 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int checkRecord(int n) {
        Set<String> list = record(n);
        System.out.println(JSONObject.toJSONString(list));
        return list.size() % 1000000007;
    }

    public Set<String> record(int n){
        Set<String> result = new HashSet<>();
        if(n == 1){
            result.add("A");
            result.add("P");
            result.add("L");
            return result;
        }
        Set<String> temp = record(n - 1);
        temp.forEach(t -> {
            // 已经缺勤过一次
            if(!t.contains("A")) {
                result.add("A".concat(t));
                result.add(t.concat("A"));
            }
            // 没有迟到过两天
            if(!t.startsWith("LL")){
                result.add("L".concat(t));
            }
            if(!t.endsWith("LL")){
                result.add(t.concat("L"));
            }
            result.add("P".concat(t));
            result.add(t.concat("P"));
        });
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord(2));
    }
}
