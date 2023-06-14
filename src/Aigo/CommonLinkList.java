package Aigo;

import Aigo.POJO.ListNode;

/**
 *@Desprition https://leetcode.cn/problems/merge-two-sorted-lists
 * 给定两个有序链表的头指针head1和head2,打印两个链表的公共部分
 * 如果两个链表的长度和为N,时间复杂度为O(N),额外空间复杂度为O(1)
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *@Author zhangshenming
 *@Date 2021/10/7 9:08
 *@Version 1.0
 */
public class CommonLinkList {
    /**
     *@Description 同时遍历两个链表，比较相同位置上的值是否相等
     *@Author zhangshenming
     *@Param head1, head2
     *@Date 2021/10/7 9:13
     *@Return void
     */
    public static void findCommon(ListNode head1,ListNode head2){
        ListNode node1 = head1;
        ListNode node2 = head2;
        System.out.println("两个链表中的公共部分是：");
        while((node1.nextNode != null) && (node2.nextNode != null)){
            if(node1.val == node2.val){
                System.out.print(node1.val+"  ");
                node1 = node1.nextNode;
                node2 = node2.nextNode;
            }else if(node1.val > node2.val){
                node2 = node2.nextNode;
            }else if(node1.val < node2.val){
                node1 = node1.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        //链表1：[1,3,5,7,9,11,10] 链表2：[1,2,4,6,8,10,12,14]
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(7);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(10);
        ListNode node16 = new ListNode(11);
        head1.nextNode = node11;
        node11.nextNode = node12;
        node12.nextNode = node13;
        node13.nextNode = node14;
        node14.nextNode = node15;
        node15.nextNode = node16;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(8);
        ListNode node25 = new ListNode(10);
        ListNode node26 = new ListNode(12);
        ListNode node27 = new ListNode(14);
        head2.nextNode = node21;
        node21.nextNode = node22;
        node22.nextNode = node23;
        node23.nextNode = node24;
        node24.nextNode = node25;
        node25.nextNode = node26;
        node26.nextNode = node27;
        findCommon(head1,head2);

    }
}
