package leetcode.Tree.numTrees;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-15 16:43
 * @desc:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

* 思路
* 递归统计次数
 */
public class numTrees {
    public static int numTrees(int n) {
        if(n <= 1){
            return 1;
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            // 左子树，左子树一定是小于根节点i的数
            int leftTress = numTrees(i - 1);
            // 右子树，右子树一定是大于根节点i的数，一共有n-i个节点，共有numTress(n-i)个二叉搜索树
            int rightTress = numTrees(n-i);
            result += leftTress * rightTress;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
