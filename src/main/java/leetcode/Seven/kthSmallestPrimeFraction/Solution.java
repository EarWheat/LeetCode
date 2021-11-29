package leetcode.Seven.kthSmallestPrimeFraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/11/29 3:40 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/29 3:40 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<int[]>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(frac, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        return frac.get(k - 1);
    }
}
