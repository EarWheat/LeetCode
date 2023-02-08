package leetcode.One.Thousand.removeSubfolders;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
//
//
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
//
//
//
//
// 示例 1：
//
//
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
//
//
// 示例 2：
//
//
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
//
//
// 示例 3：
//
//
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"]
//
//
//
// 提示：
//
//
// 1 <= folder.length <= 4 * 10⁴
// 2 <= folder[i].length <= 100
// folder[i] 只包含小写字母和 '/'
// folder[i] 总是以字符 '/' 起始
// 每个文件夹名都是 唯一 的
//
// Related Topics 字典树 数组 字符串 👍 117 👎 0
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/2/8 3:42 PM
 * @Version: 1.initial version; 2023/2/8 3:42 PM
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<String>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int pre = ans.get(ans.size() - 1).length();
            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    public List<String> removeSubfolders(List<String> folder) {
        List<String> result = new ArrayList<>();
        List<String> collect = folder.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            String f = collect.get(i);
            String fatherFloder = f.substring(0, f.length() - 2);
            if(!result.contains(fatherFloder)){
                result.add(f);
            }
        }
        if(result.size() == folder.size()){
            return result;
        } else {
            return removeSubfolders(result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
    }
}
