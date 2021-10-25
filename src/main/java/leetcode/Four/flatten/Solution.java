package leetcode.Four.flatten;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/24 5:47 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null) return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        while (true) {
            if (cur.child != null) {
                // 将 next 节点入栈
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                // 将子链表扁平化
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            // 遍历子链表的下一个节点或是从栈中弹出 next 节点
            if (cur.next != null) {
                cur = cur.next;
            } else if (!stack.isEmpty()) {
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
                cur = next;
            } else {
                return head;
            }
        }
    }

    public static void main(String[] args) {

    }
}
