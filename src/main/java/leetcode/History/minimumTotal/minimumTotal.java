package leetcode.History.minimumTotal;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-14 11:07
 * @desc:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

思路：
* 该题寻找的是全局最优解，不能看局部最优。应该用动态规划来计算
* dp[i][j]表示第i层第j个数被选上的最小值
*
*
* dp[0][0] = 0;  // 初始化
* dp[1][1] = min(dp[0][1] + 2,dp[0][0] + 2) = 2
* dp[2][1] = min(dp[1][1] + 3,dp[1][0] + 3) = 3
* dp[2][2] = min(dp[1][2] + 4,dp[1][1] + 4) = 6
*
* 对于第i层的第j个数，其可能性为dp[i - 1][j] + nums[i][j] 或者  dp[i - 1][j - 1] + nums[i][j]
* 所以有dp[i][j] = Math.min(dp[i - 1][j] + nums[i][j] , dp[i - 1][j - 1] + nums[i][j])
 */
public class minimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= triangle.size(); i++){   // 每层
            dp[i][0] = 0; // 每层第0个节点初始化为0
            List<Integer> floor = triangle.get(i - 1);
            // 第一个节点，一定是上一个节点的第一个节点 + 本层的值。
            dp[i][1] = dp[i-1][1] + floor.get(0);
            for(int j = 2; j <= floor.size() - 1; j++){   // 本层每个数
                dp[i][j] = Math.min(dp[i-1][j] + floor.get(j - 1),dp[i-1][j-1] + floor.get(j - 1));
            }
            // 最后一个节点，一定是上一个节点的最后一个节点 + 本层的值。
            dp[i][floor.size()] = dp[i-1][floor.size() - 1] + floor.get(floor.size() - 1);
        }
        int lastFloor = dp.length;
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < dp[lastFloor -1].length; i++){
            result = Math.min(result, dp[lastFloor - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> test = new ArrayList<>();
        test.add(list1);
        test.add(list2);
        test.add(list3);
        test.add(list4);
        System.out.println(minimumTotal(test));
    }
}
