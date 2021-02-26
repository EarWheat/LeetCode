package leetcode.One.Thousand.findNumOfValidWords;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/26 下午2:08
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Set<Character>> wordChars = new ArrayList<>();
        List<Set<Character>> puzzleChars = new ArrayList<>();
        // 遍历words和puzzles
        initializationChars(words, wordChars);
        initializationChars(puzzles, puzzleChars);
        List<Integer> answer = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            int temp = 0;
            for (int j = 0; j < words.length; j++) {
                if(wordChars.get(j).contains(puzzles[i].charAt(0))) { // 单词包含谜面第一个字母
                    if(isAnswer(wordChars.get(j),puzzleChars.get(i))){
                        temp++;
                    }
                }
            }
            answer.add(temp);
        }
        return answer;
    }

    public void initializationChars(String[] puzzles, List<Set<Character>> puzzleChars) {
        for(String str : puzzles){
            Set<Character> temp = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                temp.add(str.charAt(i));
            }
            puzzleChars.add(temp);
        }
    }

    /**
     * 是否答案
     * @param word
     * @param puzzle
     * @return
     */
    public boolean isAnswer(Set<Character> word, Set<Character> puzzle){
        if(word.size() > puzzle.size()){
            return false;
        }
        for(Character character : word){
            if(!puzzle.contains(character)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.findNumOfValidWords(words,puzzles)));
    }
}
