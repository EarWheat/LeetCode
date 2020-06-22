package leetcode.patternMatching;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-22 15:15
 * @desc:
 * 设pattern长度为lp, value长度为lv。a的个数为Ca，则
 * Cb = lp - Ca;
 * lv = Ca * la + Cb * lb;        =>    lv = Ca * la + (lp - Ca) * lb;     Ca, lp, lv;  枚举la即可计算出lb
 */
public class patternMatchingAnswer {
    public static boolean patternMatching(String pattern, String value) {
        if(value.length() >= 1 && pattern.length() == 0){
            return false;
        }
        if(pattern.length() <= 1){
            return true;
        }
        if(pattern.length() == 2){
            if(pattern.charAt(0) != pattern.charAt(1)){
                if(value.length() == 0){
                    return false;
                }
                return true;
            }
        }
        if(pattern.charAt(0) == 'b'){
            pattern = abReplace(pattern);
        }
        int numOfa = numOfX(pattern,'a');
        int numOfb = pattern.length() - numOfa;
        // b为0, 只有a
        if(numOfb == 0){
            int la = value.length() / numOfa;
            String a = value.substring(0,la);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numOfa; i++){
                stringBuilder.append(a);
            }
            return stringBuilder.toString().equals(value);
        } else {
            // 遍历a的长度。
            for(int i = 0; i < value.length() + 1; i++){
                String a = value.substring(0,i);
                // a的长度
                int la = a.length();
                // b的长度
                int lb = (value.length() - (numOfa * la)) / numOfb;
                String b = getBString(pattern,a,value,lb);
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < pattern.length(); j++){
                    if(pattern.charAt(j) == 'a'){
                        stringBuilder.append(a);
                    }
                    if(pattern.charAt(j) == 'b'){
                        stringBuilder.append(b);
                    }
                }
                if(stringBuilder.toString().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String abReplace(String pattern){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'a'){
                stringBuilder.append('b');
            }
            if(pattern.charAt(i) == 'b'){
                stringBuilder.append('a');
            }
        }
        return stringBuilder.toString();
    }

    // 获取字符串b
    public static String getBString(String pattern, String a, String value, int lb){
        if(lb < 1){
            return "";
        }
        for (int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'a'){
                value = value.substring(a.length());
            }
            if(pattern.charAt(i) == 'b'){
                return value.substring(0,lb);
            }
        }
        return "";
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
//        System.out.println(patternMatching("abb","dogcatfish"));    // false
//        System.out.println(patternMatching("aaaa","dogcatcatdog"));     // false
//        System.out.println(patternMatching("aaaa","dogdogdogdog"));     // true
//        System.out.println("=============");
//        System.out.println(patternMatching("aa","dogdogfish"));     // false
//        System.out.println(patternMatching("ab","dogdogfishdog"));     // true
//        System.out.println(patternMatching("abba","dogdogdogdog"));    // true
//        System.out.println(patternMatching("aba","dogdogfishdog"));    // true
        System.out.println("-------");
//        System.out.println(patternMatching("ab",""));
//        System.out.println(patternMatching("bbba", "xxxxxxy"));
//        System.out.println(patternMatching("aaaaab","xahnxdxyaahnxdxyaahnxdxyaahnxdxyaauxuhuo"));
        System.out.println(patternMatching("abb","dryqxzysggjljxdxag"));
    }
}
