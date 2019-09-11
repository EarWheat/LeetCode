package leetcode.FindInSecondArray;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-11 18:00
 * @desc:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int high = array.length;    //3
        int wide = array[0].length;//5
        //比最小的小，比最大的大
        if(target < array[0][0] || target > array[high-1][wide-1]){
            return false;
        }
        //先纵向比较，再横行比较
        for(int i  = high - 1; i >= 0; i --){
            if(target == array[i][0] || target == array[i][wide - 1]){
                return true;
            }
            //再横行折半查找
            if(target > array[i][0]){
                int middle = wide / 2;
                while (target != array[i][middle] || target!= array[i][middle-1]){
                    middle = middle / 2;
                    if(middle < 1){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {{12,15,18,20,21},{23,24,25,29,33},{34,38,44,54,66},};
        Solution solution = new Solution();
        if(solution.Find(23,array)){
            System.out.println("hello");
        }
    }
}
