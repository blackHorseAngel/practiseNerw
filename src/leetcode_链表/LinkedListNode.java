package leetcode_链表;

/**
 *@Desprition
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *@Author zhangshenming
 *@Date 2021/7/21 10:16
 *@Version 1.0
 */
public class LinkedListNode {
     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }

         public ListNode() {

         }
     }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
