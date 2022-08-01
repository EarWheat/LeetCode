package Interview.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/29 5:09 PM
 * @Version: 1.initial version; 2022/7/29 5:09 PM
 */
public class Trie {

    /**
     * 假头节点
     */
    private Trie fakeHead;
    /**
     * 当前的值
     */
    private Character val;
    /**
     * 是否结束
     */
    private Boolean isEnd;

    /**
     * 子树
     */
    private List<Trie> child;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        fakeHead = new Trie(' ');
    }

    public Trie(Character c) {
        this.val = c;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        insert(word, fakeHead);
    }

    public void insert(String word, Trie trie) {
        if (word.length() == 0) {
            return;
        }
        List<Trie> child = trie.child;
        if (child == null) {
            Trie newTire = new Trie(word.charAt(0));
            newTire.insert(word.substring(1), newTire);
            child = new ArrayList<>();
            child.add(newTire);
        } else {
            Character current = word.charAt(0);
            for (Trie newTire : child) {
                if (newTire.val.equals(current)) {
                    newTire.insert(word.substring(1));
                    break;
                }
            }
            Trie newTire = new Trie();
            newTire.insert(word);

        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
    }
}
