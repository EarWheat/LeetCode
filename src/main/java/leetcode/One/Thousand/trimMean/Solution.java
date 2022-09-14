package leetcode.One.Thousand.trimMean;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/14 7:37 PM
 * @Version: 1.initial version; 2022/9/14 7:37 PM
 */
public class Solution {
    /**
     * 设元素数目为 nn，我们先对整数数组 \textit{arr}arr 从小到大进行排序，然后对区间 \big [ \dfrac{n}{20}, \dfrac{19n}{20} \big )[
     * 20
     * n
     * ​
     *  ,
     * 20
     * 19n
     * ​
     *  ) 内的元素进行求和，得到未删除元素的求和结果 \textit{partialSum}partialSum，返回均值 \dfrac{\textit{partialSum}}{0.9n}
     * 0.9n
     * partialSum
     * ​
     *   。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/solution/shan-chu-mou-xie-yuan-su-hou-de-shu-zu-j-8r8c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int partialSum = 0;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            partialSum += arr[i];
        }
        return partialSum / (n * 0.9);
    }
}
