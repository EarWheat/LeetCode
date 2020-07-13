package leetcode.letterCombinations;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-13 17:51
 * @desc:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class letterCombinations {

    private static final String[] Two = new String[]{"a","b","c"};
    private static final String[] Three = new String[]{"d","e","f"};
    private static final String[] Four = new String[]{"g","h","i"};
    private static final String[] Five = new String[]{"j","k","l"};
    private static final String[] Six = new String[]{"m","n","o"};
    private static final String[] Seven = new String[]{"p","q","r","s"};
    private static final String[] Eight = new String[]{"t","u","v"};
    private static final String[] Nine = new String[]{"w","x","y","z"};

    
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        List<String> temp = new ArrayList<>();
        List<String> tempList;
        Character character = digits.charAt(0);
        switch (character){
            case '2':
                temp = Arrays.asList(Two);
                break;
            case '3':
                temp = Arrays.asList(Three);
                break;
            case '4':
                temp = Arrays.asList(Four);
                break;
            case '5':
                temp = Arrays.asList(Five);
                break;
            case '6':
                temp = Arrays.asList(Six);
                break;
            case '7':
                temp = Arrays.asList(Seven);
                break;
            case '8':
                temp = Arrays.asList(Eight);
                break;
            case '9':
                temp = Arrays.asList(Nine);
                break;
        }
        if(digits.length() == 1){
            return temp;
        }
        for(int i = 0; i < temp.size(); i++){
            tempList = letterCombinations(digits.substring(1));
            if(tempList != null){
                for(int j = 0; j < tempList.size(); j++){
                    result.add(temp.get(i).concat(tempList.get(j)));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
