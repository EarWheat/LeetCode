package leetcode.Nine.isAlienSorted;

/**
 * @Desc: 953. 验证外星语词典
 * @Author: 泽露
 * @Date: 2022/5/17 3:29 PM
 * @Version: 1.initial version; 2022/5/17 3:29 PM
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if(words[i].equals(words[i + 1])){
                continue;
            }
            if(!isPreWords(words[i], words[i + 1], order)){
                return false;
            }
        }
        return true;
    }

    public boolean isPreWords(String word1, String word2, String order){
        int length = Math.min(word1.length(), word2.length());
        int i = 0;
        while (i < length && word1.charAt(i) == word2.charAt(i)) i++;
        if(i == length && word1.charAt(i - 1) == word2.charAt(i - 1)){
            return word1.length() < word2.length();
        }
        char w1 = word1.charAt(i);
        char w2 = word2.charAt(i);
        return isPreOrder(w1, w2, order);
    }

    public boolean isPreOrder(char c1, char c2, String order){
        for(Character c : order.toCharArray()){
            if(c == c2){
                return false;
            }
            if(c == c1){
                return true;
            }
        }
        return false;
    }
}
