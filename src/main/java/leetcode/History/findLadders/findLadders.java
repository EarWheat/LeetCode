package leetcode.History.findLadders;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-07 14:45
 * @desc:
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
//TODO:未完成
public class findLadders {
    //beginWord = "hit",
    //endWord = "cog",
    //wordList = ["hot","dot","dog","lot","log","cog","hig"]
    //["hit","hot","dot","dog","cog"],
    //  ["hit","hot","lot","log","cog"]
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return result;
        }
        // 转换路径,存在多条路径
        List<String> switchRoot = new ArrayList<>();
        switchRoot.add(beginWord);
        if(beginWord.equals(endWord)){
            result.add(switchRoot);
            return result;
        }
        // 看看经过一步能变成什么
        for(int i = 0; i < wordList.size(); i++){
            // 取出wordList里面的word
            String temp = wordList.get(i);
            if(canSwitch(beginWord, temp)){
                switchRoot.add(temp);
                wordList.remove(temp);
                findLadders(temp,endWord, wordList);
            }
            if(temp.equals(endWord)){
                return result;
            }
        }
        return result;
    }

    public static List<String> ladders(String beginWord, String endWord, List<String> wordList){
        List<String> result = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return result;
        }
        if(beginWord.equals(endWord)){
            result.add(endWord);
            return result;
        }
        // 看看经过一步能变成什么
        for(int i = 0; i < wordList.size(); i++){
            // 取出wordList里面的word
            String temp = wordList.get(i);
            if(canSwitch(beginWord, temp)){
                result.add(temp);
                wordList.remove(temp);
                result.addAll(ladders(temp, endWord, wordList));
                return result;
            }
        }
        // 无法转化为任何字符串
        //TODO:转换N次后，无法再转换成任何字符串
        return new ArrayList<>();
    }

    // 能否由原始word转化为目标word，即sourceWord和targetWord长度相等且只差一个字母
    private static boolean canSwitch(String sourceWord, String targetWord){
        if(sourceWord.length() != targetWord.length()){
            return false;
        }
        int diffChar = 0;   // 差异化字母个数
        for(int i = 0; i < sourceWord.length(); i++){
            if(sourceWord.charAt(i) != targetWord.charAt(i)){
                diffChar++;
            }
        }
        if(diffChar == 1){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"hot", "dot", "dog", "lot", "log", "cog", "hig"};
        List<String> te = Arrays.asList(strings);
        List<String> wordList = new ArrayList(te);
        System.out.println(ladders("hit","cog",wordList));
    }
}
