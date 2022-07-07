package leetcode.Six.replaceWords;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/7 10:15 AM
 * @Version: 1.initial version; 2022/7/7 10:15 AM
 */
public class Solution {
    /**
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<Character, List<String>> rootMap = new HashMap<>();
        dictionary.forEach(s -> {
            if (rootMap.containsKey(s.charAt(0))) {
                List<String> strings = rootMap.get(s.charAt(0));
                strings.add(s);
            } else {
                List<String> roots = new ArrayList<>();
                roots.add(s);
                rootMap.put(s.charAt(0), roots);
            }
        });
        String[] sntences = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : sntences) {
            if(rootMap.containsKey(s.charAt(0))){
                List<String> roots = rootMap.get(s.charAt(0));
                String match = getMatch(roots, s);
                result.append(match).append(" ");
            } else {
                result.append(s).append(" ");
            }
        }
        return result.substring(0, result.length() - 1);
    }

    private String getMatch(List<String> roots, String s){
        String result = s;
        for (String root : roots) {
            if (s.startsWith(root) && root.length() < result.length()) {
                result = root;
            }
        }
        return result;
    }
}
