package leetcode.Third.topKFrequent;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-07 11:44
 * @desc:给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

 */
public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Set<Integer> result = new HashSet<>();   // 记录结果数据
        Map<Integer, Integer> frequent = new HashMap<>();   // 记录频率
        Integer minFrequent = Integer.MAX_VALUE;    // 高频数组里面的最低次数
        for(int i = 0; i < nums.length; i++){
            // 该数频率+1
            if(frequent.containsKey(nums[i])){
                frequent.put(nums[i], frequent.get(nums[i]) + 1);
            } else {
                frequent.put(nums[i],1);
            }
            // 未到前k个高频数，直接添加
            if(result.size() < k && !result.contains(nums[i])){
                result.add(nums[i]);
                minFrequent = Math.min(minFrequent,frequent.get(nums[i]));
            } else {
                // 先前的k个高频数已经满了，需要替换
                if(!result.contains(nums[i]) && frequent.get(nums[i]) >= minFrequent){
                    // 替换，先找result中最小的索引
                    for(Integer index : result){
                        if(frequent.get(index).equals(minFrequent)){
                            result.remove(index);
                            result.add(nums[i]);
                            break;
                        }
                    }
                    // 更新结果集里面的最小频率
                    int temp = Integer.MAX_VALUE;
                    for(Integer index : result){
                        temp = Math.min(temp,frequent.get(index));
                    }
                    minFrequent = temp;
                }
            }
        }
        return result.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }

}
