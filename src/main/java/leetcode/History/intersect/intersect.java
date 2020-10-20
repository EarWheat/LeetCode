package leetcode.History.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-13 14:05
 * @desc:
 * 给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

 */
public class intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (true){
            if(i >= nums1.length || j >= nums2.length){
                break;
            }
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            } else {
                if(nums1[i] > nums2[j]){
                    j++;
                } else {
                    i++;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
