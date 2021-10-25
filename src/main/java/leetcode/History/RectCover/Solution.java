package leetcode.History.RectCover;

/*
 * @author:liuzhaolu
 * @createTime: 2019-10-08 19:35
 * @desc:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().RectCover(4));
    }
}
