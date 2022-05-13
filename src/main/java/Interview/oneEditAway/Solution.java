package Interview.oneEditAway;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/13 3:16 PM
 * @Version: 1.initial version; 2022/5/13 3:16 PM
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)){
            return true;
        }
        if(Math.abs(first.length() - second.length()) == 1){
            if(first == "" || second == ""){
                return true;
            }
            int i = 0,j =0;
            int length = Math.max(first.length(), second.length());
            int diff = 0;
            while (i < length && j < length){
                if(first.charAt(i) == second.charAt(j)){
                    i++;
                    j++;
                } else {
                    if(first.length() > second.length()){
                        i++;
                    } else {
                        j++;
                    }
                    diff++;
                }
            }
            return diff == 1;
        }
        if(first.length() == second.length()){
            int diff = 0;
            int i = 0;
            while (i < first.length()){
                if(first.charAt(i) != second.charAt(i)){
                    diff++;
                }
                i++;
            }
            return diff <= 1;
        }
        return false;
    }
}
