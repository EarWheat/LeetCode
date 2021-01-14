package leetcode.One.Thousand.prefixesDivBy5;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/14 下午4:10
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class prefixesDivBy5 {
    /**
     * 可被5整除的数字只跟该数字的最后一位数字（为0或5）有关系，于是不需要具体的算出二进制前缀对应的十进制整数是多少，只需每次保留最后一位数字（保留用该数字对10取余的十进制整数的结果）就好，而下一个二进制前缀对应的十进制整数 = 上一次的结果左移一位（乘以2）的结果 + 这次的A[i]（0或者1，正好对应十进制的0或者1）的结果。
     * @param A
     * @return
     */
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int temp = 0;
        List<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            temp <<= 1;
            temp += A[i];
            temp %= 10;
            answer.add(temp % 5 == 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        System.out.println(JSONObject.toJSONString(prefixesDivBy5(A)));
    }
}
