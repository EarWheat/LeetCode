package Interview.hammingWeight;

/**
 * @Desc: 剑指 Offer 15. 二进制中1的个数
 * @Author: 泽露
 * @Date: 2022/5/26 2:17 PM
 * @Version: 1.initial version; 2022/5/26 2:17 PM
 */
public class Solution {
    public int hammingWeight(int n) {
        // 1011
        // 0001
        int result = 0;
        int z = 0;
        while (z != 32){
            if((n & 1) == 1){
                result++;
            }
            z++;
            n = n >> 1;
        }
        return result;
    }
}
