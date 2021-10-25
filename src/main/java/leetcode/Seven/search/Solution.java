package leetcode.Seven.search;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/6 7:45 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int search(int[] nums, int target) {
        return middleSearch(nums, target, 0, nums.length);
    }

    public int middleSearch(int[] nums, int target, int left, int right){
        if(left >= right){
            return -1;
        }
        int middle = (right + left) / 2;
        if(nums[middle] == target){
            return middle;
        }
        if(target > nums[middle]){
            return middleSearch(nums, target, middle + 1, right);
        } else {
            return middleSearch(nums, target, left, middle);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},2));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},5));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},3));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},12));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},-1));
    }
}
