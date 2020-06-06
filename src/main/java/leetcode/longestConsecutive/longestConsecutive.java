package leetcode.longestConsecutive;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-06 15:24
 * @desc:给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
思路：
* 1、正向遍历获取最长序列
* 2、反向遍历获取最长序列
* 3、是否可拼接。
 */
public class longestConsecutive {
    public int answer(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;

    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int result = 1;
        int temp = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == 1){
                temp += 1;
            } else if(nums[i] == nums[i -1]){
                continue;
            } else {
                result = Math.max(result, temp);
                temp = 1;
            }
        }
        return Math.max(result, temp);
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,0}));
    }
}
