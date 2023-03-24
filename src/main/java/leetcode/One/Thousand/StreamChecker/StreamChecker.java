package leetcode.One.Thousand.StreamChecker;
//设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
//
// 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到
// "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
//
// 按下述要求实现 StreamChecker 类：
//
//
// StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
// boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回
//true ；否则，返回 false。
//
//
//
//
// 示例：
//
//
//输入：
//["StreamChecker", "query", "query", "query", "query", "query", "query",
//"query", "query", "query", "query", "query", "query"]
//[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"],
//["i"], ["j"], ["k"], ["l"]]
//输出：
//[null, false, false, false, true, false, true, false, false, false, false,
//false, true]
//
//解释：
//StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
//streamChecker.query("a"); // 返回 False
//streamChecker.query("b"); // 返回 False
//streamChecker.query("c"); // 返回n False
//streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
//streamChecker.query("e"); // 返回 False
//streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
//streamChecker.query("g"); // 返回 False
//streamChecker.query("h"); // 返回 False
//streamChecker.query("i"); // 返回 False
//streamChecker.query("j"); // 返回 False
//streamChecker.query("k"); // 返回 False
//streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 2000
// 1 <= words[i].length <= 200
// words[i] 由小写英文字母组成
// letter 是一个小写英文字母
// 最多调用查询 4 * 10⁴ 次
//
// Related Topics 设计 字典树 数组 字符串 数据流 👍 116 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/3/24 11:06 AM
 * @Version: 1.initial version; 2023/3/24 11:06 AM
 */
public class StreamChecker {
    TrieNode root;
    TrieNode temp;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.getChild(index) == null) {
                    cur.setChild(index, new TrieNode());
                }
                cur = cur.getChild(index);
            }
            cur.setIsEnd(true);
        }
        root.setFail(root);
        Queue<TrieNode> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if(root.getChild(i) != null) {
                root.getChild(i).setFail(root);
                q.add(root.getChild(i));
            } else {
                root.setChild(i, root);
            }
        }
        while (!q.isEmpty()) {
            TrieNode node = q.poll();
            node.setIsEnd(node.getIsEnd() || node.getFail().getIsEnd());
            for (int i = 0; i < 26; i++) {
                if(node.getChild(i) != null) {
                    node.getChild(i).setFail(node.getFail().getChild(i));
                    q.offer(node.getChild(i));
                } else {
                    node.setChild(i, node.getFail().getChild(i));
                }
            }
        }

        temp = root;
    }

    public boolean query(char letter) {
        temp = temp.getChild(letter - 'a');
        return temp.getIsEnd();
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    TrieNode fail;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode getChild(int index) {
        return children[index];
    }

    public void setChild(int index, TrieNode node) {
        children[index] = node;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean b) {
        isEnd = b;
    }

    public TrieNode getFail() {
        return fail;
    }

    public void setFail(TrieNode node) {
        fail = node;
    }
}
