package leetcode.Six.repeatedStringMatch;

/**
 * @author ：liuzhaolu
 * @description：686. 重复叠加字符串匹配
 * @prd : https://leetcode-cn.com/problems/repeated-string-match/
 * @date ：2021/12/22 5:06 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/22 5:06 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int repeatedStringMatch(String a, String b) {
        char startChar = b.charAt(0);
        String originalA = new String(a);
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == startChar){
                int result = 1;
                while (a.length() < b.length()){
                    a = a + originalA;
                    result++;
                }
                if(a.equals(b)){
                    return result;
                } else {
                    if(isSubString(b,a)){
                        return result;
                    }
                    a = a + originalA;
                    result++;
                    return isSubString(b,a) ? result : -1;
                }
            }
        }
        return -1;
    }

    public boolean isSubString(String a, String b){
        int index = 0;
        while (index < b.length()){
            if(a.charAt(0) == b.charAt(index)){
                int indexA = 0;
                int indexB = index;
                while (indexA < a.length() && indexB < b.length()){
                    if(a.charAt(indexA) == b.charAt(indexB)){
                        indexA++;
                        indexB++;
                    } else {
                        break;
                    }
                }
                if(indexA == a.length()){
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "aaac";
        String b = "aac";
        Solution solution = new Solution();
        System.out.println(solution.repeatedStringMatch(a,b));
    }
}
