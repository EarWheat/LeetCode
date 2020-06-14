package leetcode.findBestValue;

import java.text.DecimalFormat;
import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-14 15:49
 * @desc:
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。

 

示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361
 

提示：

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5
 */
public class findBestValue {
    public static int findBestValue(int[] arr, int target) {
        if(arr.length <= 1){
            return arr[0];
        }
        double tempMiddle = (float)target / (float)arr.length;
        double maxMiddle = Math.ceil(tempMiddle);
        int middle=0;
        if(maxMiddle - tempMiddle >= 0.5){
            middle = (int)tempMiddle;
        } else {
            middle = (int)maxMiddle;
        }
//        int middle = Math.round((float)target / (float)arr.length);
        // 排序
        Arrays.sort(arr);
        // 所有值都比均值大，需要减小;
        if(arr[0] >= middle){
            return middle;
        }
        if(arr[arr.length - 1] <= middle){
            return arr[arr.length-1];
        }
        return findBestValue(Arrays.copyOfRange(arr,1,arr.length), target - arr[0]);
    }

    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{15,1,1,1,1,1,1,1,1,1,1,1},50));   // 15
        System.out.println(findBestValue(new int[]{2,3,5},11));   // 5
        System.out.println(findBestValue(new int[]{4,9,3},10));     // 3
        System.out.println(findBestValue(new int[]{2,3,5}, 10));    // 5
        System.out.println(findBestValue(new int[]{2,3,7}, 12));    // 7
        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803)); // 11361
        System.out.println(findBestValue(new int[]{1547,83230,57084,93444,70879},71237));  // 17422

        System.out.println("===========================");
        System.out.println(youhuaAnswer(new int[]{15,1,1,1,1,1,1,1,1,1,1,1},50));   // 15
        System.out.println(youhuaAnswer(new int[]{2,3,5},11));   // 5
        System.out.println(youhuaAnswer(new int[]{4,9,3},10));     // 3
        System.out.println(youhuaAnswer(new int[]{2,3,5}, 10));    // 5
        System.out.println(youhuaAnswer(new int[]{2,3,7}, 12));    // 7
        System.out.println(youhuaAnswer(new int[]{60864,25176,27249,21296,20204}, 56803)); // 11361
        System.out.println(youhuaAnswer(new int[]{1547,83230,57084,93444,70879},71237));  // 17422
    }

    // 优化答案
    public static int youhuaAnswer(int[] arr, int target){
        if(arr.length <= 1){
            return arr[0];
        }
        Arrays.sort(arr);
        return findBestValueV2(arr, target);
    }

    public static int findBestValueV2(int[] arr, int target){
        if(arr.length <= 1){
            return arr[0];
        }
        double tempMiddle = (float)target / (float)arr.length;
        double maxMiddle = Math.ceil(tempMiddle);
        int middle;
        if(maxMiddle - tempMiddle >= 0.5){
            middle = (int)tempMiddle;
        } else {
            middle = (int)maxMiddle;
        }
        // 所有值都比均值大，需要减小;
        if(arr[0] >= middle){
            return middle;
        }
        // 最大值都比middle小
        if(arr[arr.length - 1] <= middle){
            return arr[arr.length-1];
        }
        // 一次性去掉比middle小的数
        int i = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i] >= middle){
                break;
            }
            target = target - arr[i];
        }
        return findBestValueV2(Arrays.copyOfRange(arr,i ,arr.length), target);
    }
}
