package leetcode.Three.lexicalOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/4/18 3:10 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/18 3:10 下午     liuzhaolu       firstVersion
 */
public class Answer {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }
}
