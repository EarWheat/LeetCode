package leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-29 09:54
 * @desc:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
               [-2, -1, 0, 0, 1, 2]
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 */
public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //剪枝
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue;
            if (nums[i] + 3 * nums[i + 1] > target) continue;
            for (int j = i + 1; j <= nums.length - 2;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + 2 * nums[nums.length - 1] < target) continue;
                if (nums[i] + nums[j] + 2 * nums[j + 1] > target) continue;
                int t = target - nums[i] - nums[j];
                int p = j + 1, q = nums.length - 1;
                while(p < q){
                    if (nums[p] + nums[q] < t){
                        p++;
                    }else if (nums[p] + nums[q] > t){
                        q--;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        res.add(list);
                        p++;
                        q--;
                        //去重
                        while (p < q && nums[p] == nums[p - 1]) p++;
                        while (p < q && nums[q] == nums[q + 1]) q--;
                    }
                }
            }
        }
        return res;
    }

    // [-1, 0, 0, 1, 2]    target = 2
    // nums是数组，target是和，count代表是N数之和
    private static List<List<Integer>> oneMethod(int[] nums, int target, int count){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        if(count <= 0){
            return result;
        }
        if(count == 1){
            for(int i = 0; i < nums.length;i++){
                if(nums[i] == target){
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            return result;
        } else {
            // N数之和
            for (int i = 0; i < nums.length; i++){
                List<List<Integer>> t = oneMethod(removeIndex(nums,i),target - nums[i], --count);
                for(List<Integer> list : t){
                    list.add(nums[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    // 删除
    private static int[] removeIndex(int[] nums,int index){
        for (int i = index; i < nums.length - 1;i++){
            nums[i] = nums[i + 1];
        }
        return Arrays.copyOfRange(nums,0,nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
}
