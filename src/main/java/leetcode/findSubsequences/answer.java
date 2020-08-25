package leetcode.findSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-25 14:04
 * @desc:
 */
public class answer {
    // set暴力去重
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        // 确保搜索到所有的组合位置
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                dfs(nums,j,tmp);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(int[] nums, int c, List<Integer> tmp) {
        if (c >= nums.length) {
            return;
        }

        // 满足递增序列，加入解集
        if (nums[c] >= tmp.get(tmp.size() - 1)) {
            tmp.add(nums[c]);
            if (tmp.size() >= 2) {
                ans.add(new ArrayList<>(tmp));
            }
            dfs(nums,c + 1,tmp);
            tmp.remove(tmp.size() - 1);
        }

        // 避免搜索遗漏
        if (nums[c] != tmp.get(tmp.size() - 1)) {
            dfs(nums,c + 1,tmp);
        }
    }
}
