package Aigo;

import Aigo.POJO.ListNode;

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
public class RemoveDumplicated {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prevNode = head;
        ListNode curNode = head;
        while(curNode.nextNode != null){
            if(prevNode.val == curNode.nextNode.val){
                prevNode.nextNode = curNode.nextNode.nextNode;
            }else{
                prevNode = prevNode.nextNode;
                curNode = curNode.nextNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        //[1,2]
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        head.nextNode = listNode1;
        ListNode listNode2 = new ListNode(2);
        listNode1.nextNode = listNode2;
//        listNode2.nextNode = null;
        //[1,2,3]
        ListNode listNode3 = new ListNode(3);
        listNode2.nextNode = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.nextNode = listNode4;
        listNode4.nextNode = null;
        ListNode node = deleteDuplicates(head);
        while(node.nextNode != null){
            System.out.println(node.val);
            node = node.nextNode;
        }
    }
}
