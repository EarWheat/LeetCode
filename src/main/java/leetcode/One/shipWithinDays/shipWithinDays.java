package leetcode.One.shipWithinDays;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/26 下午2:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 找到一个index使得左右的重量尽量相近
    public int splitWeights(int[] weights, int left, int right, int D){
        if(D == 1){
            return Arrays.stream(weights).sum();
        }
        int leftWeights = weights[left++];
        int rightWeights = weights[right--];
        while (left < right){
            if(leftWeights <= rightWeights){
                leftWeights += weights[left++];
            }
            if(leftWeights >= rightWeights){
                rightWeights += weights[right--];
            }
        }
        int middle = Math.min(left, right);
        if(D == 2){
            return Math.max(leftWeights,rightWeights);
        } else {
            D = D - 2;
            return Math.max(splitWeights(weights,0,middle,D),splitWeights(weights,middle,weights.length,D));
        }
    }
}
