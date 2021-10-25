package leetcode.Seven.reorganizeString;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-30 18:14
 * @desc 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class reorganizeString {
    /**
     * 两个指针交换
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        if(S.length() <= 1){
            return S;
        }
        char[] chars = new char[S.length()];
        for(int i = 0; i < chars.length; i++){
            chars[i] = S.charAt(i);
        }
        int slow = 0;
        int fast = 0;
        while (slow < S.length() - 1){
            if(chars[slow] != chars[slow + 1]){
                slow++;
            } else {    // 相同字母相邻

                fast = slow + 2;
                if(fast >= S.length()){
                    return "";
                }
                while (fast < S.length()){
                    if(chars[fast] != chars[slow + 1]){
                        // 交换slow + 1 和 fast
                        char temp = chars[fast];
                        chars[fast] = chars[slow + 1];
                        chars[slow + 1] = temp;
                        slow = slow + 2;
                        break;
                    }
                    fast++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < chars.length;i++){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("baaba"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aaab"));
    }
}
