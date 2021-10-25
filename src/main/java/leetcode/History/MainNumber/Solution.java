package leetcode.History.MainNumber;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-16 21:45
 * @desc:
 */
public class Solution {

    private static int MainNumber(int[] array){
        //存储结果数组
        int[] result = new int[array.length];
        for(int i = 0; i < array.length;i++){
            int index = array[i];
            result[index]++;        //因为值是小于n的，所以可以用坐标来表示值
        }
        //求主元素及其次数
        for(int i = 0; i < result.length;i ++){
            if(result[i] > result.length / 2){
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[] array = {0,5,5,3,5,7,5,5};
        int[] arrayB = {0,5,5,3,5,1,5,7};
        System.out.println(MainNumber(array));
        System.out.println(MainNumber(arrayB));
    }
}
