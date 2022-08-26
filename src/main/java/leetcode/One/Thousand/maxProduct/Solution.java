package leetcode.One.Thousand.maxProduct;

/**
 * @Desc: 1464 数组中两元素的最大乘积
 * @Author: 泽露
 * @Date: 2022/8/26 4:56 PM
 * @Version: 1.initial version; 2022/8/26 4:56 PM
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int maxIndex = 0;
        int secIndex = 1;
        int max;
        int sec;
        if(nums[maxIndex] < nums[secIndex]){
            int temp = maxIndex;
            maxIndex = secIndex;
            secIndex = temp;
        }
        max = nums[maxIndex];
        sec = nums[secIndex];
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] > max){
                secIndex = maxIndex;
                maxIndex = i;
                max = nums[maxIndex];
                sec = nums[secIndex];
            } else if(nums[i] > sec && nums[i] <= max){
                secIndex = i;
                sec = nums[secIndex];
            }
        }
        return (nums[maxIndex] - 1) * (nums[secIndex] - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{2,2,1,8,1,5,4,5,2,10,3,6,5,2,3}));
    }
}
