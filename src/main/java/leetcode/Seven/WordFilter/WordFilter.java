package leetcode.Seven.WordFilter;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/14 3:49 PM
 * @Version: 1.initial version; 2022/7/14 3:49 PM
 */
public class WordFilter {

    private String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        for (int i = words.length - 1; i >= 0; i--) {
            String temp = words[i];
            if(temp.startsWith(pref) && temp.endsWith(suff)){
                return i;
            }
        }
        return -1;
    }
}
