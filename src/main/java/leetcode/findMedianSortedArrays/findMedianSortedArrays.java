package leetcode.findMedianSortedArrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-02 17:49
 * @desc:给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 */
public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        System.out.println(findMedianSortedArrays(nums3,nums4));
        int[] nums5 = {};
        int[] nums6 = {1};
        System.out.println(findMedianSortedArrays(nums5,nums6));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 偶数中位数
        if((length1 + length2) % 2 == 0){
            int middle = (length1 + length2) / 2;
            int middle2 = middle - 1;
            double[] result = sort(nums1,nums2,middle);
            return (result[middle2] + result[middle]) / 2;
        } else {
            int middle = (length1 + length2) / 2;
            double[] result = sort(nums1, nums2, middle);
            return result[middle];
        }
    }

    public static double[] sort(int[] nums1, int[] nums2, int index){
        double[] result = new double[nums1.length + nums2.length];
        int count = 0;
        int i = 0;
        int j = 0;
        while (count <= index){
            if(i >= nums1.length){
                result[count++] = nums2[j];
                j++;
                continue;
            }
            if(j >= nums2.length){
                result[count++] = nums1[i];
                i++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                result[count++] = nums1[i];
                i++;
            } else {
                result[count++] = nums2[j];
                j++;
            }
        }
        return result;
    }
}
