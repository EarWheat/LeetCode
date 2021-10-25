package leetcode.Five.reverseStr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/20 3:20 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String reverseStr(String s, int k) {
        boolean reverse = true;
        // 将结果切片
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if((i + 1) % k == 0){
                String temp;
                if(reverse){
                    temp = stringBuilder.reverse().toString();
                    reverse = false;
                } else {
                    temp = stringBuilder.toString();
                    reverse = true;
                }
                result.add(temp);
                stringBuilder.delete(0,stringBuilder.length());
            }
        }
        result.add(reverse ? stringBuilder.reverse().toString() : stringBuilder.toString());
        StringBuilder res = new StringBuilder();
        result.forEach(res::append);
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg",4));
    }
}
