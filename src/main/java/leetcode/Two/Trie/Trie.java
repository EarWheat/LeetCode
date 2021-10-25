package leetcode.Two.Trie;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/14 下午7:47
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Trie {



    private Set<String>[] nodes;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Set[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char c = word.charAt(0);
        int index = c - 'a';
        Set<String> set;
        if(nodes[index] == null){
            set = new HashSet<>();
            set.add(word);
            nodes[index] = set;
        } else {
            set = nodes[index];
            set.add(word);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char c = word.charAt(0);
        int index = c - 'a';
        if(nodes[index] == null){
            return false;
        } else {
            return nodes[index].contains(word);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char c = prefix.charAt(0);
        int index = c - 'a';
        if(nodes[index] == null){
            return false;
        } else {
            for(String s : nodes[index]){
                if(s.startsWith(prefix)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));   // 返回 True
//        System.out.println(trie.search("app"));     // 返回 False
//        System.out.println(trie.startsWith("app")); // 返回 True
//        trie.insert("app");
//        System.out.println(trie.search("app"));     // 返回 True
        trie.insert("zero");
        System.out.println(trie.search("zer"));     // 返回 True
    }
}
