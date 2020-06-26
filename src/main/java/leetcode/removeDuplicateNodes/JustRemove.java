package leetcode.removeDuplicateNodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-26 15:45
 * @desc:
 *  * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
 */
public class JustRemove {
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(head.val);
        while (temp.next != null){
            // 下个节点
            ListNode nextNode = temp.next;
            if(set.contains(nextNode.val)){
                // 下下个节点存在
                if(nextNode.next != null){
                    temp.next = nextNode.next;
                } else {
                    temp.next = null;
                    break;
                }
            } else {
                set.add(nextNode.val);
                temp = nextNode;
            }
        }
        return head;
    }

    public static ListNode packNode(Object[] nums){
        if(nums.length < 1){
            return null;
        }
        if(nums.length == 1){
            return new ListNode((int)nums[0]);
        }
        ListNode node = new ListNode((int)nums[0]);
        node.next = packNode(Arrays.copyOfRange(nums,1,nums.length));
        return node;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 1, 1, 1, 2};
        ListNode node = packNode(nums);
//        while (node != null){
//            System.out.print(node.val + " => ");
//            node = node.next;
//        }
        ListNode test = removeDuplicateNodes(node);
        while (test != null){
            System.out.print(test.val + " => ");
            test = test.next;
        }
    }
}
