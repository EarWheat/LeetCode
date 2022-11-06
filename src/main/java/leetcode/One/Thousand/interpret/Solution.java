package leetcode.One.Thousand.interpret;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/6 4:19 PM
 * @Version: 1.initial version; 2022/11/6 4:19 PM
 */
public class Solution {
    public String interpret(String command) {
        return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }
}
