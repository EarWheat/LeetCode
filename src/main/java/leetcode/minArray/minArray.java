package leetcode.minArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-22 08:19
 * @desc:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0

 */
public class minArray {
    public static int minArray(int[] numbers) {
        int min = numbers[0];
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] < min){
                return numbers[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3,4,5,1,2}));
        System.out.println(minArray(new int[]{2,2,2,0,1}));
    }
}
