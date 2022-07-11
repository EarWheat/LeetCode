package leetcode.Six.MagicDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/11 11:40 AM
 * @Version: 1.initial version; 2022/7/11 11:40 AM
 */
public class MagicDictionary {

    Set<String> dictionarySet;

    public MagicDictionary() {
        dictionarySet = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        dictionarySet.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        for (String word : dictionarySet){
            if(canSwitch(searchWord, word)){
                return true;
            }
        }
        return false;
    }

    private boolean canSwitch(String searchWord, String targetWord){
        if(searchWord.length() != targetWord.length()){
            return false;
        }
        int diff = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            if(searchWord.charAt(i) != targetWord.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
