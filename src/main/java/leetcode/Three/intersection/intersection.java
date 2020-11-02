package leetcode.Three.intersection;

import sun.invoke.empty.Empty;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-02 11:48
 * @desc 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            return nums1;
        }
        if(nums2.length == 0){
            return nums2;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length;i++){
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                if(!list.contains(nums2[i])){
                    list.add(nums2[i]);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
