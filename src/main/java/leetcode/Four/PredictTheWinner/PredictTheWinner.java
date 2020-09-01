package leetcode.Four.PredictTheWinner;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-01 00:52
 * @desc:给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

 

示例 1：

输入：[1, 5, 2]
输出：False
解释：一开始，玩家1可以从1和2中进行选择。
如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
因此，玩家 1 永远不会成为赢家，返回 False 。
示例 2：

输入：[1, 5, 233, 7]
输出：True
解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 */
public class PredictTheWinner {
    /**
     *
     * @param nums
     * @return
     */
    public static boolean PredictTheWinner(int[] nums) {
        int[] result = BiggestNum(nums);
        return result[0] >= result[1];
    }

    /**
     * 返回两个值，一个是玩家1的最大值，一个是玩家2的值
     * @param nums
     * @return
     */
    public static int[] BiggestNum(int[] nums){
        int[] result = new int[2];
        // 递归，如果只剩两个数，一定能赢
        if(nums.length == 1){
            result[0] = nums[0];
            return result;
        }
        if(nums.length == 2){
            if(nums[0] >= nums[1]){
                result[0] = nums[0];
                result[1] = nums[1];
            } else {
                result[0] = nums[1];
                result[1] = nums[0];
            }
            return result;
        }
        // 玩家1先选，因为每个玩家的玩法都会使他的分数最大化，所以玩家2一定是最大值。
        // 先拿最左边的数，能拿到的最大分数
        int[] left = BiggestNum(Arrays.copyOfRange(nums,1,nums.length));
        int leftPlayer2 = left[0]; // 玩家2的分数
        int leftPlayer1 = nums[0] + left[1]; // 玩家1的分数
        // 先拿最右边的数，能拿到的最大分数
        int[] right = BiggestNum(Arrays.copyOfRange(nums,0,nums.length - 1));
        int rightPlayer2 = right[0];
        int rightPlayer1 = nums[nums.length - 1] + right[1];
        if(leftPlayer1 >= rightPlayer1){
            result[0] = leftPlayer1;
            result[1] = leftPlayer2;
        } else {
            result[0] = rightPlayer1;
            result[1] = rightPlayer2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1,5,2}));
        System.out.println(PredictTheWinner(new int[]{1,5,233,7}));
    }
}
