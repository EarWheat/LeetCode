package leetcode.History.countSmaller;

import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-11 10:37
 * @desc:
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0]
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.

*
* in: 5,2,6,4,1
* out:3,1,2,1,0
* 思路：
* 从最后往前遍历，最后一个一定是0
* 判断当前元素是否大于右元素
* 大：
* 向右追溯比当前元素小的值(假设该元素位置为index)，于是有当前值counts[i] = counts[index] + 1
*
* // 利用快排能迅速知道数组中有多少个小于和大于当前的数
 */
public class countSmaller {
    // 暴力求解
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            counts[i] += QuickSort(nums,i,nums.length);
        }
        return Arrays.asList(counts);
    }

    public static int QuickSort(int nums[], int low, int high){
        if(low > high){
            return low;
        }
        int i = low;
        int j = high;
        int temp = nums[low];
        while (i < j){
            // 从后往前遍历找比temp小的数
            while (i < j){
                if(nums[j] < temp){
                    break;
                }
                j--;
            }
            while (i < j){
                if(nums[i] > temp){
                    break;
                }
                i++;
            }
            // 交换
            if(i < j) {
                int k = nums[j];
                nums[j] = nums[i];
                nums[i] = k;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5,2,6,4,1}));
    }
}
