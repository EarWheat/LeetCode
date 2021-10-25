package leetcode.Zero.numDecodings;

import java.util.HashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/21 下午2:09
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class numDecodings {
    public int numDecodings(String s) {
        if(s.startsWith("0")){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        if(s.length() == 2){
            Integer i = Integer.valueOf(s);
            if(i > 0 && i <= 26){
                if(i == 10 || i == 20){
                    return 1;
                }
                return 2;
            } else {
                return 1;
            }
        }
        String first = s.substring(0,2);
        Integer i = Integer.valueOf(first);
        if(i > 26){
            return numDecodings(s.substring(1));
        } else {
            return numDecodings(s.substring(2)) + numDecodings(s.substring(1));
        }
    }

    public int numDecodingsV2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public static void main(String[] args) {
        HashMap map = new HashMap();
        numDecodings numDecodings = new numDecodings();
        System.out.println(numDecodings.numDecodings("10"));
    }
}
