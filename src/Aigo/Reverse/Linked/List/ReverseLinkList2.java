package Aigo.Reverse.Linked.List;

import Aigo.POJO.ListNode;

/**
 *@Desprition 反转链表
 *@Author zhangshenming
 *@Date 2021/10/14 17:07
 *@Version 1.0
 */
public class ReverseLinkList2 {
    /**
     *@Description
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/14 17:08
     *@Return Aigo.POJO.ListNode
     */
    public static ListNode reverseLinkList(ListNode head){
        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode tempNode = null;
        node1.next = null;
        while (node2 != null){
            tempNode = node2.next;
            node2.next = node1;
            node1 = node2;
            node2= tempNode;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode newHead = reverseLinkList(head);
        ListNode currentNode = newHead;
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
}
