package leetcode.One.ladderLength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-05 14:12
 * @desc 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ladderLength {
    /**
     *  * 输入:
     *  * beginWord = "hit",
     *  * endWord = "cog",
     *  * wordList = ["hot","dot","dog","lot","log","cog"]
     *  *
     *  * 输出: 5
     *  *
     *  * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *  *                       "hit" -> "hot" -> "lot" -> "log" -> "cog"
     *  *      返回它的长度 5。
    **/
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0 || !wordList.contains(endWord) || beginWord.length() != endWord.length()){
            return 0;
        }
        int result = 1;
        if(differenceChar(beginWord, endWord) == 1){
            return ++result;
        }

        Stack<String> couldTransformWord;  // 第一次可转换为的单词
        List<String> newWordDict; // 新字典
        String objWord; // 目标word

        // 从beginWord转换的可能性
        Stack<String> couldTransformWordStart = new Stack<>();  // 第一次可转换为的单词
        List<String> newWordDictStart = new ArrayList<>();
        for(String str : wordList){
            if(differenceChar(beginWord,str) == 1){
                couldTransformWordStart.add(str);
            } else {
                newWordDictStart.add(str);
            }
        }
        // 从endWord转换的可能性
        Stack<String> couldTransformWordLast = new Stack<>();
        List<String> newWordDictLast = new ArrayList<>();
        for (String str: wordList){
            if(differenceChar(endWord,str) == 1){
                couldTransformWordLast.add(str);
            } else {
                newWordDictLast.add(str);
            }
        }

        if(couldTransformWordLast.size() < couldTransformWordStart.size()){
            couldTransformWord = couldTransformWordLast;
            newWordDict = newWordDictLast;
            objWord = beginWord;
        } else {
            couldTransformWord = couldTransformWordStart;
            newWordDict = newWordDictStart;
            objWord = endWord;
        }
        int length = Integer.MAX_VALUE;
        while (couldTransformWord.size() != 0){
            String temp = couldTransformWord.pop();
            int len = ladderLength(temp,objWord,newWordDict);
            if(len != 0){
                length = Math.min(length,len + 1);
            }
        }
        if(length != Integer.MAX_VALUE && length != 0){
            return length;
        } else {
            return 0;
        }
    }

    // 变换前word和目标word有多少个不同的字符
    private static int differenceChar(String beginWord, String endWord){
        int difference = 0;
        for(int i = 0; i < beginWord.length();i++){
            if(beginWord.charAt(i) != endWord.charAt(i)){
                difference++;
            }
        }
        return difference;
    }

    /**
     *  * 输入:
     *  * beginWord = "hit",
     *  * endWord = "cog",
     *  * wordList = ["hot","dot","dog","lot","log","cog"]
     *  *
     *  * 输出: 5
     *  *
     *  * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *  *      返回它的长度 5。
     **/
    public static void main(String[] args) {
        String[] strings = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(strings);
        System.out.println(ladderLength("hit","cog",list));
    }
}
