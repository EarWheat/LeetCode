package leetcode.One.Thousand.minAbsoluteSumDiff;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/14 下午7:14
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int max = 0;    // 绝对值最大差值
        int maxIndex = 0;   // 最大值的index;
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = Math.abs(nums1[i] - nums2[i]);
            sum += temp;
            if(temp > max){
                maxIndex = i;
                max = temp;
            }
        }
        int target = nums2[maxIndex];  // 需要接近的值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min = Math.min(min,Math.abs(nums1[i] - target));
        }
        return (sum + min - max) % 1000000007;
    }

    public int answer(int[] nums1, int[] nums2){
        //贪心(边遍历, 边二分查找能够使替换后优化最大的角标)
        long ans = 0;
        int max = 0;    //max指代在不同角标处, 可以做替换后能够使得绝对差之和削减最多的值
        int[] copy = nums1.clone();
        Arrays.sort(copy);  //复制出来一个数组并排序, 用于做二分法查询最接近目标值的元素
        for(int i = 0; i< nums1.length; i++){
            if(nums1[i] == nums2[i]){
                continue;
            }
            int abs = Math.abs(nums1[i]-nums2[i]);
            ans += abs;

            //贪心法, 在遍历中, 实时更新若从nums1[]中替换当前元素后, 可以削减的绝对差之和最多的值
            int tar = nums2[i];
            int start = 0;
            int end = copy.length-1;
            while(start<end){   //二分法查找最贴近nums2[i]的元素
                int mid = start + end+1 >> 1;
                if(copy[mid] > tar){
                    end = mid-1;
                }else{
                    start = mid;
                }
            }
            int n = Math.abs(tar-copy[end]);
            int convertAbs = (end == copy.length-1) ? n : Math.min(Math.abs(tar-copy[end+1]), n);    //当前角标元素调整后的的绝对差
            if(abs > convertAbs){
                max = Math.max(max, abs-convertAbs);    //取值为: 能有效缩减当前元素绝对差之和的替换元素
            }
        }
        return (int)((ans-max)%1000000007);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,28,21};
        int[] nums2 = new int[]{9,21,20};
        Solution solution = new Solution();
        System.out.println(solution.minAbsoluteSumDiff(nums1,nums2));
    }
}
