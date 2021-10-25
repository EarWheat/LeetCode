package leetcode.Five.findLongestWord;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/14 4:46 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String[] dict = dictionary.toArray(new String[0]);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length()){
                    return -1;
                } else if (s1.length() < s2.length()){
                    return 1;
                } else {
                    // 字典序列
                    for (int i = 0; i < s1.length(); i++) {
                        if(s1.charAt(i) > s2.charAt(i)){
                            return 1;
                        } else if(s1.charAt(i) < s2.charAt(i)){
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        });
        for (int i = 0; i < dict.length; i++) {
            if(wordMatch(s, dict[i])){
                return dict[i];
            }
        }
        return "";
    }

    public boolean wordMatch(String s, String word){
        if(word.length() > s.length()){
            return false;
        }
        int slow = 0;
        int fast = 0;
        while (fast < s.length()){
            if(s.charAt(fast) == word.charAt(slow)){
                slow++;
                if(slow == word.length()){
                    return true;
                }
            }
            fast++;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"1","2","2"};
        String[] str2 = new String[]{"2"};
        List<String> list1 = Arrays.stream(str).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(str2).collect(Collectors.toList());
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.removeToMerge(list1, list2)));
    }

    public List<String> removeToMerge(List<String> list1, List<String> list2){
        List<String> result = new ArrayList<>();
        list1.forEach(s ->{
            if(list2.contains(s)){
                list2.remove(s);
            } else {
                result.add(s);
            }
        });
        return result;
    }
}
