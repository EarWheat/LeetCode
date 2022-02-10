package leetcode.Util;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-13 11:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ListNodeUtil {
    public static ListNode array2ListNode(int[] array){
        if(array.length <= 0){
            return new ListNode();
        }
        ListNode head = new ListNode(array[0]);
        ListNode next = head;
        for(int i = 1; i < array.length;i++){
            ListNode temp = new ListNode(array[i]);
            next.next = temp;
            next = temp;
        }
        return head;
    }

    public static void printNode(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            System.out.println();
            node = node.next;
        }
    }
}
