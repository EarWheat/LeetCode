package Interview.isFlipedString;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/29 11:35 AM
 * @Version: 1.initial version; 2022/9/29 11:35 AM
 */
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char startC = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == startC) {
                String tail = s1.substring(i, s1.length());
                String head = s1.substring(0, i);
                if ((tail + head).equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
    }
}
