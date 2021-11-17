package leetcode.Three.maxProduct;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/17 9:55 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/17      liuzhaolu       firstVersion
 */
public class Solution {
    public int maxProduct(String[] words) {
        /**
         全是小写字母, 可以用一个32为整数表示一个word中出现的字母,
         hash[i]存放第i个单词出现过的字母, a对应32位整数的最后一位,
         b对应整数的倒数第二位, 依次类推. 时间复杂度O(N^2)
         判断两两单词按位与的结果, 如果结果为0且长度积大于最大积则更新
         **/
        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(char c : words[i].toCharArray())
                hash[i] |= 1 << (c-'a');
        }

        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }

}

