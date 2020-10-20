package leetcode.History.patternMatching;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-22 10:08
 * @desc:你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

示例 1：

输入： pattern = "abba", value = "dogcatcatdog"
输出： true
示例 2：

输入： pattern = "abba", value = "dogcatcatfish"
输出： false
示例 3：

输入： pattern = "aaaa", value = "dogcatcatdog"
输出： false
示例 4：

输入： pattern = "abba", value = "dogdogdogdog"
输出： true
解释： "a"="dogdog",b=""，反之也符合规则

* 思路：
* abba = baab  这俩是一样的，只是交换a和b的值，所以默认为a开头
* 1、第一个字母一定为a的首字母，x指向第一个字母。遍历后续看能否找到同样开头的a字母，y指向后续同样的字母。           // dogcatcatfish按此方法找不出a
* 2、x和y同时右移，相同则继续，不同则break；即可找出字符a；
* 3、value去掉a，同样的方式即可找出b。
* 4、最后进行匹配
*
* 思路2：
* 1、递归实现，即pattern = "abba", value = "dogcatcatdog"  等价于 (pattern = "abb", value = "dogcatcat") && a == "dogcatcatdog" - "dogcatcat"
* 说明，要看abba能否匹配dogcatcatdog等价于  abb匹配
* 2、表达式：
*  patternMatching(String pattern, String value) == patternMatching(pattern.subString(0,length()-1), )
*
*
* 答案：
* 
 */
public class patternMatching {
    public static boolean patternMatching(String pattern, String value) {
        if(value.length() == 0){
            return false;
        }
        if(pattern.length() <= 1){
            return true;
        }
        if(pattern.length() == 2){
            if(pattern.charAt(0) != pattern.charAt(1)){
                return true;
            }
        }
        // 找到a
        String a = findWord(value);
        // 以b开头的value
        String newValue = value.substring(a.length());
        String b = findWord(newValue);
        while (a.equals(b)){
            newValue = newValue.substring(a.length());
            b = findWord(newValue);
        }
        // 看看ab是否能组成value的长度
        int numOfa = numOfX(pattern,'a');
        int numOfb = numOfX(pattern,'b');
        // 如果不匹配，则重新计算ab
        if((numOfa * a.length() + numOfb * b.length()) != value.length()){

        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'a'){
                stringBuilder.append(a);
            }
            if(pattern.charAt(i) == 'b'){
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString().equals(value);
    }

    public static String findWord(String value){
        if(value.length() == 0){
            return "";
        }
        // 找到相同首字母
        char first = value.charAt(0);
        int y;
        for(y = 1; y < value.length(); y++){
            if(value.charAt(y) == first){
                break;
            }
        }
        if(y == value.length()){
            return value;
        }
        int x = 0;
        int temp = y;
        while (y < value.length() && x < temp){
            if(value.charAt(x) == value.charAt(y)){
                x++;
                y++;
            } else {
                break;
            }
        }
        return value.substring(0,x);
    }

    public static int numOfX(String string, char x){
        int result = 0;
        for(int i = 0;i < string.length(); i++){
            if(string.charAt(i) == x){
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(patternMatching("abba","dogcatcatdog"));     // true
//        System.out.println(patternMatching("abba","dogcatcatfish"));    // false
//        System.out.println(patternMatching("abb","dogcatcat"));    // true
//        System.out.println(patternMatching("abb","dogcatfish"));    // true
//        System.out.println(patternMatching("aaaa","dogcatcatdog"));     // false
//        System.out.println(patternMatching("aaaa","dogdogdogdog"));     // true
        System.out.println("=============");
        System.out.println(patternMatching("aa","dogdogfish"));     // false
        System.out.println(patternMatching("ab","dogdogfishdog"));     // true
        System.out.println(patternMatching("abba","dogdogdogdog"));    // true
        System.out.println(patternMatching("aba","dogdogfishdog"));    // true
    }
}
