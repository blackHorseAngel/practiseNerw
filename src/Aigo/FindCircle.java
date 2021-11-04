package Aigo;

import Aigo.POJO.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *@Desprition 查找一个链表中是否有环
 *@Author zhangshenming
 *@Date 2021/10/24 9:39
 *@Version 1.0
 */
public class FindCircle {
    /**
     *@Description 使用hashMap用来记录链表中节点出现的次数
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/24 9:43
     *@Return Aigo.POJO.ListNode
     */
    public static ListNode find1(ListNode head){
       Set<ListNode> set= new HashSet<ListNode>();
        ListNode curr = head;
        int length = 0;
        while (curr != null){
            if(!set.contains(curr)){
                set.add(curr);
                curr = curr.nextNode;
                length++;
            }
        }
        System.out.println("该链表的长度是："+length);
        return curr;
    }
    /**
     *@Description 快慢指针：快指针每次前进两步，慢指针每次前进一步，当快慢指针相遇的时候说明
     * 该链表有环，把快指针再放回头部，慢指针位置不变，当他们再次相遇的时候，是该链表中的环的起点
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/24 9:55
     *@Return Aigo.POJO.ListNode
     */    
    public static ListNode find2(ListNode head){
        ListNode fastNode = head.nextNode.nextNode;
        ListNode slowNode = head.nextNode;
        while(fastNode != slowNode){
            fastNode = fastNode.nextNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        fastNode = head;
        while(fastNode != slowNode){
            fastNode = fastNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        return fastNode;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node6;
        node6.nextNode = node7;
        node7.nextNode = node4;
        ListNode circleNode1 = find1(head);
        System.out.println("1链表中的环节点是：" + circleNode1);
        ListNode circleNode2 = find2(head);
        System.out.println("2链表中的换节点是：" + circleNode2);
    }
}
