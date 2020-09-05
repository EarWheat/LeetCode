package leetcode.getPermutation;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-05 15:21
 * @desc:
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

 */
public class getPermutation {
    /**
     * "123"    "12"
     * "132"    "21"
     * "213"
     * "231"
     * "312"
     * "321"
     * 3 * 2 * 1
     *
     * "1234"
     * "1243"
     * "1324"
     * "1342"
     * "1423"
     * "1432"
     * "2134"
     * "2143"
     * "2314"
     * "2341"
     * "2413"
     * "2431"
     * "312"
     * "321"
     * 4 * 3 * 2 * 1
     * 因为n的排列会有n个数作为排列的开始，每种开头的排列有(n - 1)!种。所以k／(n-1)!就知道是以哪种排序开始，k % (n - 1)!就知道是以哪种开始的第k%(n-1)个位置
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0){
            return "";
        }
        if(n == 1){
            String[] strings = new String[1];
            strings[0] = "1";
            return strings[k-1];
        }
        if(n == 2){
            String[] strings = new String[2];
            strings[0] = "12";
            strings[1] = "21";
            return strings[k-1];
        }
        int[] nums = new int[n];
        for(int i = 0;i < n; i++){
            nums[i] = i + 1;
        }
        // 例如n = 3， k = 3则startNum = 1; index = 1，即代表以nums[1]开头的第1个数就是结果
        int temp = factorial(n - 1);
        int startNum = k / temp;
        int index = k % temp;
        // 刚好没余数
        if(index == 0){
            startNum = startNum - 1;
            index = temp;
        }

        // 求以startNum开头的全排列
        LinkedList<String> result = sort(subNums(nums,startNum));

        return String.valueOf(nums[startNum]).concat(result.get(index - 1));
    }

    public int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    // nums全排列
    private LinkedList<String> sort(int[] nums){
        LinkedList<String> result = new LinkedList<>();
        if(nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            LinkedList<String> temp = sort(subNums(nums,i));
            for (String str : temp){
                result.add(String.valueOf(nums[i]).concat(str));
            }
        }
        return result;
    }

    private int[] subNums(int[] nums,int index){
        int[] temp = new int[nums.length - 1];
        for(int i = 0; i < index; i++){
            temp[i] = nums[i];
        }
        for(int i = index + 1; i < nums.length; i++){
            temp[i - 1] = nums[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        getPermutation getPermutation = new getPermutation();
//        System.out.println(getPermutation.getPermutation(1,1));
        System.out.println(getPermutation.getPermutation(5,120));
        System.out.println(getPermutation.getPermutation(9,37));
        System.out.println(getPermutation.getPermutation(3,2));
        System.out.println(getPermutation.getPermutation(4,9));
        System.out.println(getPermutation.getPermutation(0,3));
        System.out.println(getPermutation.getPermutation(3,0));
    }
}
