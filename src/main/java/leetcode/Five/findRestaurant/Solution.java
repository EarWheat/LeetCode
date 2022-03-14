package leetcode.Five.findRestaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：599. 两个列表的最小索引总和
 * @prd : https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * @date ：2022/3/14 10:19 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/14 10:19 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        int n1 = list1.length, n2 = list2.length;
        int mx = Integer.MAX_VALUE;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j == mx) {
                        ans.add(list1[i]);
                    } else if (i + j < mx) {
                        mx = i + j;
                        ans.clear();
                        ans.add(list1[i]);
                    }
                }
            }
        }
        return (String[])ans.toArray(new String[0]);
    }
}
