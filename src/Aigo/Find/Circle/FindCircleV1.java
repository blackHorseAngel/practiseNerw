package Aigo.Find.Circle;

import Aigo.POJO.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *@Desprition 查找一个链表中是否有环
 *@Author zhangshenming
 *@Date 2021/10/24 9:39
 *@Version 1.0
 */
public class FindCircleV1 extends FindCircleSuper {
    /**
     *@Description 使用hashMap用来记录链表中节点出现的次数
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/24 9:43
     *@Return Aigo.POJO.ListNode
     */
    public  ListNode find(ListNode head){
       Set<ListNode> set= new HashSet<ListNode>();
        ListNode curr = head;
        int length = 0;
        while (curr != null){
            if(!set.contains(curr)){
                set.add(curr);
                curr = curr.next;
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
        ListNode fastNode = head.next.next;
        ListNode slowNode = head.next;
        while(fastNode != slowNode){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        fastNode = head;
        while(fastNode != slowNode){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
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
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;
        FindCircleV1 findCircleV1 = new FindCircleV1();
        ListNode circleNode1 = findCircleV1.find(head);
        System.out.println("1链表中的环节点是：" + circleNode1);
//        ListNode circleNode2 = find2(head);
//        System.out.println("2链表中的换节点是：" + circleNode2);
    }
}
