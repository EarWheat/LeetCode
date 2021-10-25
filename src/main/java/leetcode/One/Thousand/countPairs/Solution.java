package leetcode.One.Thousand.countPairs;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/7 下午7:30
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int countPairs(int[] deliciousness) {
        int count  = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if(is2M(deliciousness[i] + deliciousness[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean is2M(int i){
        while (i > 1){
            if(i % 2 != 0){
                return false;
            }
            i = i / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] foods = new int[]{1,3,5,7,9};
        Solution solution = new Solution();
        System.out.println(solution.countPairs(foods));
    }
}
