package leetcode.Eight.largeGroupPositions;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/5 下午3:38
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class largeGroupPositions {
    /**
     * 输入：s = "abcdddeeeeaabbbcd"
     * 输出：[[3,5],[6,9],[12,14]]
     * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
     *
     * @param s
     * @return
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if(s.length() < 3){
            return result;
        }
        int start = 0;
        int end = 1;
        while (end < s.length()){
            if(s.charAt(end) == s.charAt(start)){
                end++;
            } else {
                if(end - start >= 3){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(end - 1);
                    result.add(temp);
                    start = end;
                    end++;
                } else {
                    start++;
                    end = start + 1;
                }
            }
        }
        if(end == s.length()){
            if(end - start >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end - 1);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(largeGroupPositions("bababbabaa")));
    }
}
