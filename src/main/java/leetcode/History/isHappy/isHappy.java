package leetcode.History.isHappy;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-30 15:03
 * @desc:编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

 

示例：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 *
 *
 * 思路：所有位置相加为偶数就一定是快乐数，否则不是
 * 答案：对于每次计算各位平方和之后的数，如果map中存在这个数，说明无论计算多少次都无法达到1，此时直接返回false；否则将这个数存入map，并对这个数进行上述操作。
 */
public class isHappy {

    public static void main(String[] args) {
        String sOid = "TVRRME1USTVOemMyT0RBMk5qazVNamcxTVE9PQ==";
        System.out.println(sOid.substring(0, sOid.length() - 2));
//        System.out.println(isHappy(10));
    }

    public static boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                temp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (map.containsKey(temp)) {
                return false;
            } else {
                map.put(temp, 1);
            }
            n = temp;
        }
        return true;
    }
}
