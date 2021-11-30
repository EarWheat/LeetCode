package leetcode.Four.findNthDigit;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/11/30 5:39 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/30 5:39 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        char r = stringBuilder.charAt(n - 1);
        return (r - 48);
    }

    public int answer(int n) {
        int low = 1, high = 9;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }
}
