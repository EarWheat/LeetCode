package leetcode.Four.constructRectangle;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/23 4:05 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/23      liuzhaolu       firstVersion
 */
public class Solution {
    public int[] constructRectangle(int area) {
        double temp = Math.sqrt(area);
        int a = (int)temp;
        int b = a + 1;
        while (a * b != area){
            while (a * b > area){
                b--;
            }
            if(a * b == area){
                break;
            }
            a++;
        }
        return new int[]{Math.max(a,b),Math.min(a,b)};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.constructRectangle(4));
    }
}
