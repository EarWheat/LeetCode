package leetcode.Two.Thousand.count;

import java.util.Arrays;

/**
 * @Desc: 2719. 统计整数数目
 * @Author: 泽露
 * @Date: 2024/1/16 4:50 PM
 * @Version: 1.initial version; 2024/1/16 4:50 PM
 */
public class Solution {
    static final int N = 23;
    static final int M = 401;
    static final int MOD = 1000000007;
    int[][] d;
    String num;
    int min_sum;
    int max_sum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        d = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], -1);
        }
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        return (get(num2) - get(sub(num1)) + MOD) % MOD;
    }

    public int get(String num) {
        this.num = new StringBuffer(num).reverse().toString();
        return dfs(num.length() - 1, 0, true);
    }

    // 求解 num - 1，先把最后一个非 0 字符减去 1，再把后面的 0 字符变为 9
    public String sub(String num) {
        char[] arr = num.toCharArray();
        int i = arr.length - 1;
        while (arr[i] == '0') {
            i--;
        }
        arr[i]--;
        i++;
        while (i < arr.length) {
            arr[i] = '9';
            i++;
        }
        return new String(arr);
    }

    public int dfs(int i, int j, boolean limit) {
        if (j > max_sum) {
            return 0;
        }
        if (i == -1) {
            return j >= min_sum ? 1 : 0;
        }
        if (!limit && d[i][j] != -1) {
            return d[i][j];
        }
        int res = 0;
        int up = limit ? num.charAt(i) - '0' : 9;
        for (int x = 0; x <= up; x++) {
            res = (res + dfs(i - 1, j + x, limit && x == up)) % MOD;
        }
        if (!limit) {
            d[i][j] = res;
        }
        return res;
    }
}