package leetcode.Four.minMutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/7 3:38 PM
 * @Version: 1.initial version; 2022/5/7 3:38 PM
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<>(Arrays.asList(bank));
        return mutation(start, end, banks);
    }

    public int mutation(String start, String end, Set<String> banks){
        if(banks.contains(end)){
            if(diffOne(start, end)){
                return 1;
            } else {
                banks.remove(end);
                int result = Integer.MAX_VALUE;
                for (String bank : banks) {
                    if (!bank.equalsIgnoreCase(end) && diffOne(end, bank)) {
                        Set<String> newBanks = new HashSet<>(banks);
                        int step = mutation(start, bank, newBanks);
                        if (step != -1) {
                            result = Math.min(step + 1, result);
                        }
                    }
                }
                return result == Integer.MAX_VALUE ? -1 : result;
            }
        }
        return -1;
    }

    public boolean diffOne(String s1, String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMutation("AAAAACCC","AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
