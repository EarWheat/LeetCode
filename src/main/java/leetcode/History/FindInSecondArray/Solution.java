package leetcode.History.FindInSecondArray;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-11 18:00
 * @desc:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {};
        Solution solution = new Solution();
        if(solution.Find(7,array)){
            System.out.println("hello");
        }
    }
}
