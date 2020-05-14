package main.java.leetcode.singleNumber;

import java.util.HashSet;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-14 15:56
 * @desc:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int result = 0;
        for(int i : set){
            result = i;
        }
        return result;
    }

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     * var a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     * @param nums
     * @return
     */
    private int answer(int[] nums){
        // 异或 ⊕ 的特性
        // 0 异或 x  = x
        // x 异或 b = b
        // b 异或 b = 0
        int res = 0;
        for(int i:nums){
            res ^= i;
        }
        // 最后返回是落单的
        return res;
    }
}
