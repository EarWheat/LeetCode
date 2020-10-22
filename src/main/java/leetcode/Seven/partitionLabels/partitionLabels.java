package leetcode.Seven.partitionLabels;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-22 17:12
 * @desc 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 *
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class partitionLabels {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S.length() == 0){
            return result;
        }
        if(S.length() == 1){
            result.add(1);
            return result;
        }
        String subStr = S.substring(0,S.length() - 1);
        char newChar = S.charAt(S.length() - 1);
        List<Integer> temp = partitionLabels(subStr);
        int tempIndex = 0;
        for(Integer integer:temp){
            String str = subStr.substring(tempIndex,tempIndex + integer);
            // 最新的在这里面，则需要更新
            if(isContainChar(str,newChar)){
                result.add(S.length() - tempIndex);
                return result;
            }
            tempIndex += integer;
            result.add(integer);
        }
        // newChar是单独的新字符需要单独长度1
        result.add(1);
        return result;
    }

    private static Boolean isContainChar(String s, char c){
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == c){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ababcdefe";
        String s1 = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(JSON.toJSONString(partitionLabels(s1)));
        System.out.println(JSON.toJSONString(result));
    }
}
