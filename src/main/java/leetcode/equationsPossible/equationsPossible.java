package leetcode.equationsPossible;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-08 12:46
 * @desc:给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 

 

示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true
 

提示：

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='

* 思路：维护两个set，一个是相等的set，一个是不等的set
 */
public class equationsPossible {
    public static boolean equationsPossible(String[] equations) {
        String str;
        List<Set<Character>> equalList = new ArrayList<>();
        boolean isContains = false;
        for(int i = 0; i < equations.length; i++){
            str = equations[i];
            char left = str.charAt(0);
            char right = str.charAt(3);
            if(str.charAt(1) == '='){
                if(left == right){
                    continue;
                }
                for(Set<Character> equals: equalList){
                    if(equals.contains(left)){
                        equals.add(right);
                        isContains = true;
                        break;
                    }
                    if(equals.contains(right)){
                        equals.add(left);
                        isContains = true;
                        break;
                    }
                }
                if(!isContains){
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(left);
                    newSet.add(right);
                    equalList.add(newSet);
                }
            }
        }
        // 合并等式集合
        for(Set<Character> equals : equalList){

        }
        // 不等式
        for(int i =0; i < equations.length; i++){
            str = equations[i];
            char left = str.charAt(0);
            char right = str.charAt(3);
            if(str.charAt(1) == '!'){
                if(left == right){
                    return false;
                }
                for(Set<Character> equals: equalList){
                    if(equals.contains(left)){
                        if(equals.contains(right)){
                            return false;
                        }
                    }
                    if(equals.contains(right)){
                        if(equals.contains(left)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] strings = new String[]{"a==b","b!=c","c==a"};
//        String[] strings1 = new String[]{"b==b","b==e","e==c","d!=e"};
        String[] strings2 = new String[]{"a==b","e==c","b==c","a!=e"};

//        System.out.println(equationsPossible(strings));
//        System.out.println(equationsPossible(strings1));
        System.out.println(equationsPossible(strings2));
    }
}
