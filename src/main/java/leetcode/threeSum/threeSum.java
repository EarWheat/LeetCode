package leetcode.threeSum;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-12 14:52
 * @desc:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*
* 答案：
* 不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：

第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；

第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。

也就是说，我们枚举的三元组 (a, b, c)(a,b,c) 满足 a \leq b \leq ca≤b≤c，保证了只有 (a, b, c)(a,b,c) 这个顺序会被枚举到，而 (b, a, c)(b,a,c)、(c, b, a)(c,b,a) 等等这些不会，这样就减少了重复。要实现这一点，我们可以将数组中的元素从小到大进行排序，随后使用普通的三重循环就可以满足上面的要求。

同时，对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复。举个例子，如果排完序的数组为

* 这种方法的时间复杂度仍然为 O(N^3)O(N
3
 )，毕竟我们还是没有跳出三重循环的大框架。然而它是很容易继续优化的，可以发现，如果我们固定了前两重循环枚举到的元素 aa 和 bb，那么只有唯一的 cc 满足 a+b+c=0a+b+c=0。当第二重循环往后枚举一个元素 b'b
′
  时，由于 b' > bb
′
 >b，那么满足 a+b'+c'=0a+b
′
 +c
′
 =0 的 c'c
′
  一定有 c' < cc
′
 <c，即 c'c
′
  在数组中一定出现在 cc 的左侧。也就是说，我们可以从小到大枚举 bb，同时从大到小枚举 cc，即第二重循环和第三重循环实际上是并列的关系。

 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        for(int i = 0; i < nums.length; i++){
           if((i > 0 && nums[i] != nums[i - 1]) || i == 0){
               for(int j = i + 1; j < nums.length; j++){
                   if(j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])){
                       for(int k = j + 1; k < nums.length;k++){
                           if((k == j + 1 ) || (k > j + 1 && nums[k] != nums[k - 1])){
                               if(nums[k] + nums[j] + nums[i] == 0){
                                   list = new ArrayList<>();
                                   list.add(nums[i]);
                                   list.add(nums[j]);
                                   list.add(nums[k]);
                                   result.add(list);
                                   break;
                               }
                           }
                       }
                   }
               }
           }
        }
        return result;
    }

    public static List<List<Integer>> answer(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test).toString());
    }
}
