package aigo.remove.LinkList;

import aigo.POJO.ListNode;

/**
 * @Description https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * @Author Administrator
 * @Date 2023/3/7 20:33
 * @Version 1.0.0
 */
public class RemoveDuplicated extends RemoveLinkedListSuper {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prevNode = head;
        ListNode curNode = head;
        while(curNode.next != null){
            if(prevNode.val == curNode.next.val){
                prevNode.next = curNode.next.next;
            }else{
                prevNode = prevNode.next;
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        //[1,2]
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        head.next = listNode1;
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
//        listNode2.nextNode = null;
        //[1,2,3]
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        listNode4.next = null;
        RemoveDuplicated removeDuplicated = new RemoveDuplicated();
        ListNode node = removeDuplicated.deleteDuplicates(head);
        while(node.next != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
