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
     * 当前的值
     */
    private Character val;
    /**
     * 是否结束
     */
    private Boolean isEnd = false;

    /**
     * 子树
     */
    private List<Trie> child;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
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
        insert(word, this);
    }

    public void insert(String word, Trie trie) {
        if (word.length() == 0) {
            return;
        }
        List<Trie> childs = trie.child;
        if (childs == null) {
            Trie newTire = new Trie(word.charAt(0));
            if (word.length() == 1) {
                newTire.isEnd = true;
            }
            newTire.insert(word.substring(1), newTire);
            childs = new ArrayList<>();
            childs.add(newTire);
            trie.child = childs;
        } else {
            Character current = word.charAt(0);
            boolean matchChild = false;
            for (Trie child : childs) {
                if (child.val.equals(current)) {
                    matchChild = true;
                    if (word.length() == 1) {
                        child.isEnd = true;
                    }
                    child.insert(word.substring(1));
                    break;
                }
            }
            if (!matchChild) {
                Trie newTire = new Trie(word.charAt(0));
                if (word.length() == 1) {
                    newTire.isEnd = true;
                }
                newTire.insert(word.substring(1), newTire);
                childs.add(newTire);
                trie.child = childs;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        List<Trie> child = this.child;
        for (Trie trie : child) {
            if (trie.val == word.charAt(0)) {
                if(word.length() == 1){
                    return isEnd;
                }
                return trie.search(word.substring(1));
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        List<Trie> child = this.child;
        for (Trie trie : child) {
            if (trie.val == prefix.charAt(0)) {
                return trie.startsWith(prefix.substring(1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("hella");
        trie.insert("sadsd");
        System.out.println(trie.startsWith("h"));
        System.out.println(trie.search("hella"));
    }
}
