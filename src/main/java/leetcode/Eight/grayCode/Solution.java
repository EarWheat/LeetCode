package leetcode.Eight.grayCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ：liuzhaolu
 * @description：89. 格雷编码
 * @prd : https://leetcode-cn.com/problems/gray-code/
 * @date ：2022/1/8 5:33 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/8 5:33 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 输入：n = 2
    //输出：[0,1,3,2]
    //解释：
    //[0,1,3,2] 的二进制表示是 [00,01,11,10]
    // +1 <<< -1
    // 3
    //[0, 1, 3, 2, 6, 7 ,5 ,4]
    // 000, 001, 011, 010,
    // 110, 111, 101, 100
    // +1 <<< -1 <<< 1 +1 -1 -1
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i <= n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < result.size(); j++) {
                stack.push(result.get(j));
            }
            for (int j = 0; j < Math.pow(2, i - 1); j++) {
                while (!stack.empty()){
                    result.add((int) (stack.pop() + Math.pow(2, i - 1)));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}
