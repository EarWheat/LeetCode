package leetcode.Three.largestDivisibleSubset;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/23 下午2:28
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 1){
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.size() == 0){
                Queue<Integer> queue = new LinkedBlockingQueue<>();
                queue.add(nums[i]);
                list.add(queue);
            } else {
                boolean needNewQueue = true;
                for(Queue<Integer> q : list){
                    if(q.size() > 0){
                        if(isMatch(nums[i],q)){
                            q.add(nums[i]);
                            needNewQueue = false;
                        }
                    }
                }
                if(needNewQueue){
                    Queue<Integer> queue = new LinkedBlockingQueue<>();
                    queue.add(nums[i]);
                    list.add(queue);
                }
            }
        }
        list.sort(new Comparator<Queue<Integer>>() {
            @Override
            public int compare(Queue<Integer> o1, Queue<Integer> o2) {
                if(o1.size() > o2.size()){
                    return -1;
                } else if(o1.size() < o2.size()){
                    return 1;
                }
                return 0;
            }
        });
        Queue<Integer> temp = list.get(0);
        while (temp.size() > 0){
            result.add(temp.poll());
        }
        return result;
    }

    public boolean isMatch(int num, Queue<Integer> q){
        for(Integer i : q){
            if(num % i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,9,18,54,108,540,90,180,360,720};
        System.out.println(JSONObject.toJSONString(solution.largestDivisibleSubset(nums)));
    }

}
