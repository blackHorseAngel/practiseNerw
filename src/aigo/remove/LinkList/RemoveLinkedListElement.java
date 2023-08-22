package aigo.remove.LinkList;

import aigo.POJO.ListNode;

/**
 * @Description https://leetcode.cn/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 输入：head = [], val = 1
 * 输出：[]
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * @Author Administrator
 * @Date 2023/3/7 18:07
 * @Version 1.0.0
 */
public class RemoveLinkedListElement extends RemoveLinedListElementSuper {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        while(head != null && head.val == val){
          head = head.next;
        }
        ListNode curNode = head;
            while (curNode != null && curNode.next != null){
                if(curNode.next.val == val){
                    curNode.next = curNode.next.next;
                }else{
                    curNode = curNode.next;
                }
            }
        return head;
    }

    public static void main(String[] args) {
        //[]
//        ListNode head = null;
        //[1,2,3,4,5]
//        ListNode head = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        head.nextNode = listNode1;
//        ListNode listNode2 = new ListNode(6);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(5);
//        listNode4.next = listNode5;
//        ListNode listNode6 = new ListNode(6);
//        listNode5.next = listNode6;
//        listNode6.next = null;
            //[]
//        ListNode head = new ListNode(7);
//        ListNode listNode1 = new ListNode(7);
//        head.next = listNode1;
//        ListNode listNode2 = new ListNode(7);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(7);
//        listNode2.next = listNode3;
//        listNode3.next = null;
//
        //[2]
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        head.next = listNode1;
        listNode1.next = null;
        RemoveLinkedListElement removeLinkedListElement = new RemoveLinkedListElement();
        ListNode node = removeLinkedListElement.removeElements(head,7);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
