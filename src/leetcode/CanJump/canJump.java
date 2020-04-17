package leetcode.CanJump;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-17 15:10
 * @desc:给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 */
public class canJump {

    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,1,4};
        int[] test1 = new int[]{3,2,1,0,4};
        System.out.println(canJump(test));
        System.out.println(canJump(test1));
    }

    public static boolean canJump(int[] nums) {
        Boolean result = jump(0,nums.length - 1,nums);
        return result;
    }

    private static Boolean jump(int start, int end, int[] nums){
        Boolean result = false;
        if(start == end){
            return true;
        }
        if(start > end){
            return false;
        }
        for(int i = end - 1; i >= start; i--){
            if(nums[i] >= end - i){
                result = jump(start, i, nums);
                if(result){
                    return result;
                }
            }
        }
        return result;
    }
}
