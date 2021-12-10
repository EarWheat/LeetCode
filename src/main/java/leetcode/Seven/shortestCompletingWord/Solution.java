package leetcode.Seven.shortestCompletingWord;

import org.checkerframework.checker.units.qual.C;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/10 4:19 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/10 4:19 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> chars = new HashMap<>();
        licensePlate = licensePlate.trim().toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            if (licensePlate.charAt(i) >= 'a' && licensePlate.charAt(i) <= 'z') {
                if (chars.containsKey(licensePlate.charAt(i))) {
                    chars.put(licensePlate.charAt(i), chars.get(licensePlate.charAt(i)) + 1);
                } else {
                    chars.put(licensePlate.charAt(i), 1);
                }
            }
        }
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() == o2.length()) {
                return 0;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                if ((words[i].charAt(j) >= 'a' && words[i].charAt(j) <= 'z') ||
                        (words[i].charAt(j) >= 'A' && words[i].charAt(j) <= 'Z')) {
                    if (temp.containsKey(words[i].charAt(j))) {
                        temp.put(words[i].charAt(j), temp.get(words[i].charAt(j)) + 1);
                    } else {
                        temp.put(words[i].charAt(j), 1);
                    }
                }
            }
            if (mapEquals(chars, temp)) {
                return words[i];
            }
        }
        return "";
    }

    public boolean mapEquals(HashMap<Character, Integer> a, HashMap<Character, Integer> b) {
        for (Map.Entry<Character, Integer> entry : a.entrySet()) {
            Character key = entry.getKey();
            if (b.containsKey(key) && b.get(key) >= entry.getValue()) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
