package Interview.getKthMagicNumber;
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。
//
// 示例 1:
//
// 输入: k = 5
//
//输出: 9
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 184 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/28 5:41 PM
 * @Version: 1.initial version; 2022/9/28 5:41 PM
 */
public class Solution {
    // 1，3，5，7，9，15，21 , 25 , 27,  35,
    //           3 *3  3 * 5 3 * 7 5 * 5     5 * 7 7 * 7
    /**
     * 题目分析：
     *  由题意的，某一个满足结果的数，一定是之前的某个 resultA*3 或者是 resultB*5 或者是 resultC*7 的结果
     *  并且结果一定是 这三个乘积的最小值，
     *  因此，只要能够记录 resultA、resultB、resultC 的值，再相互与 3、5、7 相乘，取其中的最小值，就是当前的目标值！
     *  需要注意，resultA、B、C 是不断变化的，并且都应该是由小到大，谁被选中，就应该取下一个值！
     *      例如 3 就是 resultA=1 的结果，此时 B、C 都等于 1，此后 resultA 取下一个值 3
     *      例如 5 就是 resultB=1 的结果，此时 resultA=3，resultC=1，此后 resultB 取下一个值 3
     *      例如 7 就是 resultC=1 的结果，此时 resultA、resultB 都等于 3，此后 resultC 取下一个值 3
     *      例如 15 就是 resultA=5 或者是 resultB=3 的结果，此时 resultC=7，此后 resultA 取下一个值 7 ，resultB 取下一个值 5
     *      自己在纸上多画画，就明白了！
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int [] result = new int[k];
        result[0] = 1;
        // 定义三个 指针，分别表示 resultA、B、C 的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            result[i] = resultN;
        }
        return result[k - 1];
    }
}
