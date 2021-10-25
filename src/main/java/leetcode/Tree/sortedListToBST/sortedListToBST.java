package leetcode.Tree.sortedListToBST;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-18 16:13
 * @desc:给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class sortedListToBST {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    /**
     * 感觉是遍历旋转一棵树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // 快慢指针找到链表的中点，中点作为根结点，两边作为左右子树
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        // 快慢指针找中间结点
        ListNode fast = head, slow = head, pre = null;
        while(fast != null && fast.next != null){
            fast =  fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // 分割出左链表，用于构造本结点的左子树
        pre.next = null;
        // 分割出右链表，用于构造本结点的右子树
        ListNode rightList = slow.next;
        // 用中间结点构造根结点
        TreeNode root = new TreeNode(slow.val);
        // 构造左子树
        root.left = sortedListToBST(head);
        // 构造右子树
        root.right = sortedListToBST(rightList);
        // 返回本结点所在子树
        return root;
    }

    // val一定是当前最大的数

    /**
     *       0                                                                                          0              0            5
     *      / \                                     -3              -3                 0               / \            / \          ／ \
     *    -3   9      ->         -10        ->     /        ->     /  \       ->      / \      ->     -3 9     ->   -3  9         -3  9
     *    /   /                                   -10             -10  0            -3  5            /  ／         /   / \       ／ \
     *  -10  5                                                                      /              -10  5        -10  5 10      -10 0
     * @param root                                                                -10
     * @param val
     * @return
     */

}
