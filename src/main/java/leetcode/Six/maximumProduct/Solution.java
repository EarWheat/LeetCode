package leetcode.Six.maximumProduct;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/20 下午2:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static int maximumProduct(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);  // 排序
        long minDu = nums[0] * nums[1];  // 最小的两个数的乘积，有可能负负得正
        long maxDu = nums[nums.length - 1] * nums[nums.length - 2];  // 最大的两个数的乘积
        if(minDu > maxDu){  // 最小的比最大的大
            // 那么就用最小的乘积乘上最大的数，不管最大的数是正是负
            if(nums[nums.length - 1] < 0){
                return (int) (maxDu * nums[nums.length - 3]);
            }
            return (int) (minDu * nums[nums.length - 1]);
        } else {
            // 一定不存在minDu < maxDu < 0;
            // minDu < 0; 即最小的数一正一负，那么最大的两个数一定为正，即maxDu > 0
            // 所以只有minDu < 0 < maxDu 或者 0 < minDu < maxDu
            // 即maxDu必大于0
            if(nums[nums.length - 3] > 0){
                return (int) (nums[nums.length - 3] * maxDu);
            } else {
                // 此时分minDu < 0 < maxDu 或者 0 < minDu < maxDu两种情况
                // 此时nums[nums.length - 3] < 0;
                // nums[nums.length - 3] * maxDu一定为负
                if(minDu > 0 && nums[nums.length - 1] > 0){
                    return (int) (minDu * nums[nums.length - 1]);
                } else {
                    // 所有数都为负数
                    return (int) (nums[nums.length - 3] * maxDu);
                }
            }
        }
    }

    public static int maximumProduct2(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);  // 排序
        if(nums[1] > 0){    // 第二个数是正数，即最大是
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else{
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }

    public static void main(String[] args) {
        int[] ts = new int[]{722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        System.out.println(maximumProduct(ts));
    }
}
