package leetcode.charsWords;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-17 20:43
 * @desc:给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。
 * @ex:
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * @ex:
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 */
public class charsWords {
    public static void main(String[] args){
        String[] words = new String[]{"cat","bt","hat","tree"};
        String[] words2 = new String[]{"hello","world","leetcode"};
        String chars = "atach";
        String chars2 = "welldonehoneyr";
        System.out.println(charsMakeWords(words,chars));
        System.out.println(charsMakeWords(words2,chars2));
    }

    public static int charsMakeWords(String[] words, String chars){
        int maxLength = 0;
        // 遍历单词
        for(String word : words){
            char[] zimu = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder(chars);
            boolean isOK = false;
            for (char c : zimu){    // 遍历每一个字符
                String strC = String.valueOf(c);
                if(stringBuilder.toString().contains(strC)){
                    int index = stringBuilder.indexOf(strC);
                    stringBuilder.deleteCharAt(index);
                    isOK = true;
                } else {
                    isOK = false;
                    break;
                }
            }
            if(isOK){
                maxLength += word.length();
            }
        }
        return maxLength;
    }
}
