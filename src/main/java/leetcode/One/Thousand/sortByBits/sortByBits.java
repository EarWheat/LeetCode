package leetcode.One.Thousand.sortByBits;

import coding.Pack;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-06 11:00
 * @desc 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sortByBits {
    /**
     * 3,5,2,6,1,8,4,7
     * 1,5,2,6,3,8,4,7
     * 1,3,2,6,5,8,4,7
     * 1,2,3,6,5,8,4,7
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            int bitCountA = Integer.bitCount(o1);
            int bitCountB = Integer.bitCount(o2);
            // 相同按原数，不同按位数
            return bitCountA == bitCountB ? o1 - o2 : bitCountA - bitCountB;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    /**
     * 3,5,2,6,1,8,4,7
     * 1,5,2,6,3,8,4,7
     * 1,3,2,6,5,8,4,7
     * 1,2,3,6,5,8,4,7
     **/
    public static void QuickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        while (i < j){
            int temp = arr[i];
            while (j > i){
                if(numOfOne(arr[j]) < numOfOne(temp)){
                    int swTemp = arr[j];
                    arr[j] = temp;
                    arr[i] = swTemp;
                    break;
                }
                j--;
            }
            while (i < j){
                if(numOfOne(arr[i]) >= numOfOne(temp)){
                    int swTemp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = swTemp;
                    break;
                }
                i++;
            }
        }
        QuickSort(arr,left,i - 1);
        QuickSort(arr,i+1,right);
    }

    private static void QuickSortV2(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(numOfOne(num[j])>=numOfOne(key) && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(numOfOne(num[i])<=numOfOne(key) && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }

    /**
     * 1 -> 0001 m = 0 n = 1     1
     * 2 -> 0010 m = 1 n = 0     1
     * 3 -> 0011 m = 1 n = 1     2
     * 4 -> 0100 m = 2 n = 0     1
     * 5 -> 0101 m = 2 m  = 1    2
     * 6 -> 0110 m = 3 n = 0     2
     * 7 -> 0111 m = 3 n = 1     3
     * 8 -> 1000 m = 1 n = 0     1
     * 9 -> 01001 m = 4 n = 1    2
     * 10 -> 01010 m = 5 n = 0   2
     * 12 -> 01100 m = 6 n = 0   2
     * 13 -> 01101
     * 14 -> 01110
     * 16 -> 10000
     * @param a
     * @return
     */
    public static int numOfOne(int a) {
        if(a == 0){
            return 0;
        }
        if(a == 1 || a == 2){
            return 1;
        }
        if(a % 2 == 0){
            a = a / 2;
            return numOfOne(a);
        } else {
            // 奇数转换成偶数
            return numOfOne(a - 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(JSONObject.toJSONString(sortByBits(arr)));
//        int[] arr0 = new int[]{3,5,2,6,1,8,4,7};
//        QuickSort(arr0,0,arr0.length - 1);
//        System.out.println(JSONObject.toJSONString(arr0));
//        int[] arr = new int[]{3,45,78,64,52,11,64,55,99,11,18};
//        int[] arr1 = new int[]{3,45,78,64,52,11,64,55,99,11,18};
//        QuickSort(arr,0,arr.length - 1);
//        System.out.println(JSONObject.toJSONString(arr));
//        Arrays.sort(arr1);
//        System.out.println(JSONObject.toJSONString(arr1));
    }
}
