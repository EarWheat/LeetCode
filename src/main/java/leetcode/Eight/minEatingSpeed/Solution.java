package leetcode.Eight.minEatingSpeed;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc: https://leetcode.cn/problems/koko-eating-bananas/
 * @Author: 泽露
 * @Date: 2022/6/7 2:48 PM
 * @Version: 1.initial version; 2022/6/7 2:48 PM
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int index = 0;
        while (index < piles.length) {
            if (match(piles, h, piles[index])) {
                break;
            }
            index++;
        }
        int result = piles[index];
        int right  = piles[index];
        int left = index == 0 ? 0 : piles[index - 1];

        while (left < right){
            int middle = (right + left) / 2;
            if(match(piles, h, middle)){
                result = Math.min(result, middle);
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }


    public boolean match(int[] piles, int h, int eachHour){
        if(eachHour == 0){
            return false;
        }
        int predictH = 0;
        for (int pile : piles) {
            if (pile < eachHour) {
                predictH += 1;
            } else {
                int shang = pile / eachHour;
                if (shang * eachHour < pile) {
                    shang += 1;
                }
                predictH += shang;
            }
        }
        return predictH <= h;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
