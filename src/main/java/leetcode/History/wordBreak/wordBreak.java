package leetcode.History.wordBreak;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-25 16:01
 * @desc:给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

 */
public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return true;
        }
        int i = 0;
        // 单词匹配
        while (i < s.length()){
            boolean matchWord = false;     // 是否找到匹配的单词。
            List<String> matchWords = new ArrayList<>();
            for(int j = 0; j < wordDict.size();j++){
                String word = wordDict.get(j);
                if(s.charAt(i) == word.charAt(0)){
                    // 匹配单词
                    int m = 1;
                    int n = i + 1;
                    while (m < word.length()){
                        if(n >= s.length()){
                            break;
                        }
                        if(s.charAt(n) == word.charAt(m)){
                            n++;
                            m++;
                        } else {
                            break;
                        }
                    }
                    // 如果m == word.length()则说明单词匹配
                    if(m == word.length()){
                        matchWords.add(word);
                    }
                }
            }
            for (String word : matchWords){
                boolean result = wordBreak(s.substring(i + word.length()),wordDict);
                if(result){
                    return true;
                }
            }
            // 全找完了都没有找到单词则不能拆分
            if(!matchWord){
                return false;
            }
        }
        // 单词全部匹配完
        if(i == s.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        List<String> list1 = new ArrayList<>();
        list1.add("cats");
        list1.add("dog");
        list1.add("sand");
        list1.add("and");
        list1.add("cat");
        list1.add("og");
        System.out.println(wordBreak("leetcode",list));        // true
        System.out.println(wordBreak("catsandog",list1));    // false
//        System.out.println(wordBreak("", list));
        List<String> list2 = new ArrayList<>();
        list2.add("car");
        list2.add("ca");
        list2.add("s");
        System.out.println(wordBreak("cars",list2));      // true
    }
}
