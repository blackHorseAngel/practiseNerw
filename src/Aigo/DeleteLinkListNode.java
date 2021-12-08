package Aigo;

import Aigo.POJO.ListNode;

/**
 *@Desprition 请编写一个函数,用于删除单链表中某个特定节点.在设计函数时需要注意,你无法访问链表的头节点head,只能直接访问要被删除的节点。
 * 题目数据保证需要删除的节点不是末尾节点.
 *输入：head=[4,5,1,9],node=5
 * 输出：[4,1,9]
 * 解释：指定链表中值为5的第二个节点,那么在调用了你的函数之后,该链表应变为4->1->9
 * 输入：head=[4,5,1,9], node=1
 * 输出：[4,5,9]
 * 解释：指定链表中值为1的第三个节点,那么在调用了你的函数之后,该链表应变为4->5->9
 * 输入：head = [-3,5,-99], node = -3
 * 输出：[5,-99]
 * 输入：head = [1,2,3,4], node = 3
 * 输出：[1,2,4]
 * 输入：head = [0,1], node = 0
 * 输出：[1]
 *@Author zhangshenming
 *@Date 2021/11/17 11:01
 *@Version 1.0
 */
public class DeleteLinkListNode {
    /**
     *@Description
     *@Author zhangshenming
     *@Param node
     *@Date 2021/11/17 11:05
     *@Return void
     */
    public static void deleteNode(ListNode node) {
        node.val = node.nextNode.val;
        node.nextNode = node.nextNode.nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = null;
        deleteNode(node1);
        ListNode curNode = head;
        while(curNode.nextNode != null){
            System.out.println(curNode);
            curNode = curNode.nextNode;
        }
    }
}
