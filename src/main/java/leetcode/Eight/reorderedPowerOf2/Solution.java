package leetcode.Eight.reorderedPowerOf2;

import java.util.Arrays;


/**
 * @author ：liuzhaolu
 * @date ：2021/10/28 4:44 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/28      liuzhaolu       firstVersion
 */
public class Solution {
    public boolean reorderedPowerOf2(int n) {
        String[] rec ={"1","2","4","8","16","23","46","128","256","125","0124","0248","0469","1289","13468",
                "23678","35566","011237","122446","224588","0145678","0122579","0134449","0368888",
                "11266777","23334455","01466788","112234778","234455668","012356789","0112344778"};
        char[] at = String.valueOf(n).toCharArray();
        Arrays.sort(at);
        String str = new String(at);
        for(String p:rec){
            if(str.equals(p)) return true;
        }
        return false;
    }
}
