package leetcode.Three.countBits;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/3 下午3:34
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class countBits {
    // 0 1 2 3 4 5
    // 0 1 1 2 1 2
    // 0 01 10 11 100 101
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        countBits countBits = new countBits();
        System.out.println(JSONObject.toJSONString(countBits.countBits(5)));
    }
}
