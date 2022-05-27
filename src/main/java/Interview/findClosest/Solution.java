package Interview.findClosest;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/27 4:25 PM
 * @Version: 1.initial version; 2022/5/27 4:25 PM
 */
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if(index2 > 0){
                    result = Math.min(result, Math.abs(index1 - index2));
                }
            } else if(words[i].equals(word2)){
                index2 = i;
                if(index1 > 0){
                    result = Math.min(result, Math.abs(index1 - index2));
                }
            }
        }
        return result;
    }
}
