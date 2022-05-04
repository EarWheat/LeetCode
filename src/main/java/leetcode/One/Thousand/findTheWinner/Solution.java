package leetcode.One.Thousand.findTheWinner;

import leetcode.Util.ListNode;

import java.util.LinkedList;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/4 9:37 AM
 * @Version: 1.initial version; 2022/5/4 9:37 AM
 */
public class Solution {



    public int findTheWinner(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int times = 0;
        int deadPlayer = 0;
        int i = 0;
        while (true) {
            if(nums[i] != -1){  // 仍然存活
                times++;  // 计数 + 1
                if(times == k){
                    nums[i] = -1; // 死亡
                    deadPlayer++; // 死亡玩家 +1
                    if(deadPlayer == n - 1){
                        break;  // 跳出循环
                    }
                    times = 0; // 计数清零
                }
            }
            i++;
            if(i >= n){
                i = 0;
            }
        }
        for (i = 0; i < n; i++) {
            if(nums[i] != -1){
                return nums[i]; // 寻找存活的玩家
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(1,1));
    }
}
