package leetcode.numberOfSubarrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-21 19:22
 * @desc:给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

 

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16

 */
public class numberOfSubarrays {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,2,1,1};
        int[] test2 = new int[]{2,4,6};
        int[] test3 = new int[]{2,2,2,1,2,2,1,2,2,2};
//        System.out.println(numberOfSubarrays(test,3));
//        System.out.println(numberOfSubarrays(test2,1));
        System.out.println(numberOfSubarrays(test3,2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int oddCount = 0;
        int arr[] = new int[len + 2];
        //记录第oddCount个奇数的下标
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                arr[++oddCount] = i;//第++oddCount个奇数的下标是i
            }
        }
        arr[0] = -1;//左边界
        arr[oddCount + 1] = len;//右边界

        // arr[i]是窗口左边界
        // arr[i+k-1] 是窗口右边界
        // arr[i-1]是左边的上一个奇数，在此之后到arr[i]都可选
        // arr[i+k]是右边的下一个奇数，在此之前都arr[i+k-1]都可选
        //前面可选部分长度为arr[i]-arr[i-1]
        //后面可选部分长度为arr[i+k]-arr[i+k-1]
        //总的可能数等于前后可选的组合

        for (int i = 1; i + k < oddCount + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;

    }

}
