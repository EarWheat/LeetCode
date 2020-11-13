package leetcode.Three.oddEvenList;

import leetcode.Util.ListNodeUtil;
import leetcode.Util.ListNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-13 10:53
 * @desc 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class oddEvenList {

    /**
     *      *  2->1->3->5->6->4->7->NULL
     *      *  1: 2->3->1->5->6->4->7->NULL
     *      *  2：2->3->6->1->5->4->7->NULL
     *      *  3: 2->3->6->7->1->5->4->NULL
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int step = 1;   // 跳跃n步
        while (fast != null){
            ListNode cur = slow;
            slow = slow.next;
            fast = skip(fast,step);
            step++;
            if(fast == null){
                break;
            }
            // 交换
            cur.next = fast;
            move(slow,fast);
            fast.next = slow;
            slow = fast;

        }
        return head;
    }

    public void move(ListNode slow, ListNode fast){
        ListNode temp = slow;
        while (temp.next != fast){
            temp = temp.next;
        }
        temp.next = fast.next;
        fast.next = slow;
    }

    public ListNode skip(ListNode node, int step){
        ListNode temp = node;
        while (step >= 0){
            if(temp.next != null){
                temp = temp.next;
            } else {
                return null;
            }
            step--;
        }
        return temp;
    }

    /**
     *  * 输入: 2->1->3->5->6->4->7->NULL
     *  * 输出: 2->3->6->7->1->5->4->NULL
     *  2->1->3->5->6->4->7->NULL
     *  1: 2->3->1->5->6->4->7->NULL
     *  2：2->3->6->5->1->4->7->NULL
     *  3: 2->3->6->7->5->1->4->NULL
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{2,1,3,5,6,4,7};
        ListNode head = ListNodeUtil.array2ListNode(array);
        head = new oddEvenList().oddEvenList(head);
        System.out.println(head.val);
    }
}
