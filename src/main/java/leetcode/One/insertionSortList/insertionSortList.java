package leetcode.One.insertionSortList;

import com.alibaba.fastjson.JSONObject;
import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-20 15:57
 * @desc 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null){
            if(next.val < pre.val){
                // 先择出待插入的值
                pre.next = next.next;
                next.next = null;
                // 插入
                head = insertNode(head,next);
                next = pre.next;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
//        sortList(head,head);
        return head;
    }

    // -1 -> 3 -> 4 -> 5
    // temp = -1; node = 0;
    public ListNode insertNode(ListNode head, ListNode node){
        ListNode temp = head;
        while (temp.next != null){
            // 小于后面的值大于当前的值
            if(temp.val >= node.val){
                node.next = temp;
                return node;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] listnode = new int[]{4,2,1,3};
        ListNode head = ListNodeUtil.array2ListNode(listnode);
        insertionSortList insertionSortList = new insertionSortList();
        head = insertionSortList.insertionSortList(head);
        System.out.println(JSONObject.toJSONString(head.val));
    }
}
