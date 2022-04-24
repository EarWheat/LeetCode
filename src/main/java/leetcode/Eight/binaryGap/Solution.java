package leetcode.Eight.binaryGap;

import java.util.LinkedList;

/**
 * @author ：liuzhaolu
 * @description：868. 二进制间距
 * @prd : https://leetcode-cn.com/problems/binary-gap/
 * @date ：2022/4/24 11:24 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/24 11:24 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int binaryGap(int n) {
        LinkedList<Integer> binary = new LinkedList<>();
        while (n >= 1){
            binary.add(n & 1);
            n = n >> 1;
        }
        int max = 0;
        int lastIndex = 0;
        int j;
        for (j = 0; j < binary.size() ; j++) {
            if(binary.get(j) == 1){
                lastIndex = j;
                break;
            }
        }
        for (; j < binary.size(); j++) {
            if(binary.get(j) == 1){
                max = Math.max(j - lastIndex, max);
                lastIndex = j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();System.out.println(solution.binaryGap(6));
    }
}
