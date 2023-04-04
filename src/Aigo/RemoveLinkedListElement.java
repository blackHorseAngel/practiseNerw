package Aigo;

import Aigo.POJO.ListNode;

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
public class RemoveLinkedListElement {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        while(head != null && head.val == val){
          head = head.nextNode;
        }
        ListNode curNode = head;
            while (curNode != null && curNode.nextNode != null){
                if(curNode.nextNode.val == val){
                    curNode.nextNode = curNode.nextNode.nextNode;
                }else{
                    curNode = curNode.nextNode;
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
//        listNode1.nextNode = listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.nextNode = listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.nextNode = listNode4;
//        ListNode listNode5 = new ListNode(5);
//        listNode4.nextNode = listNode5;
//        ListNode listNode6 = new ListNode(6);
//        listNode5.nextNode = listNode6;
//        listNode6.nextNode = null;
            //[]
//        ListNode head = new ListNode(7);
//        ListNode listNode1 = new ListNode(7);
//        head.nextNode = listNode1;
//        ListNode listNode2 = new ListNode(7);
//        listNode1.nextNode = listNode2;
//        ListNode listNode3 = new ListNode(7);
//        listNode2.nextNode = listNode3;
//        listNode3.nextNode = null;
//
        //[2]
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        head.nextNode = listNode1;
        listNode1.nextNode = null;

        ListNode node = removeElements(head,7);
        while(node != null){
            System.out.println(node.val);
            node = node.nextNode;
        }
    }
}
