package leetcode.Zero.permutation;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/22 下午4:34
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    public String[] permutation(String s) {
        Set<String> stringSet = new HashSet<>();
        if(s.length() == 1){
            return new String[]{s};
        }
        for (int i = 0; i < s.length(); i++) {
            String head = s.substring(i,i+1);
            String[] tail = permutation(s.substring(0,i).concat(s.substring(i+1)));
            for(String t : tail){
                String temp = head.concat(t);
                stringSet.add(temp);
            }
        }
        return stringSet.toArray(new String[stringSet.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.permutation("abc")));
    }
}
