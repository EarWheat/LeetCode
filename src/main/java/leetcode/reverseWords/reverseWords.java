package leetcode.reverseWords;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-30 19:43
 * @desc:
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"


 */
public class reverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word:words){
            StringBuilder stringBuilder = new StringBuilder(word);
            result.append(stringBuilder.reverse());
            result.append(" ");
        }
        return result.substring(0,result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
