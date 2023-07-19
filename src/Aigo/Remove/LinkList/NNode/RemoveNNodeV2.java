package Aigo.Remove.LinkList.NNode;

import Aigo.POJO.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/18 12:01
 * @Version 1.0.0
 */
public class RemoveNNodeV2 extends RemoveNNodeSuper {
    /**
     * 使用队列
     * @param head
     * @param n
     * @return
     */
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建一个长度等于n的队列
        Queue<ListNode> queue = new LinkedList<>();
        ListNode curNode = head;
        //需要删除的节点的父节点
        ListNode targetSuperNode = null;
        //循环链表，将其中的节点依次放入队列中，如果队列满了，就取出队列头部的元素，直到链表的全部元素结束。那么此时队列的头部元素就是需要删除的元素
        while (curNode != null) {
            if(queue.size() == n){
                targetSuperNode = queue.poll();
            }
            queue.offer(curNode);
            curNode = curNode.next;
        }
        if(targetSuperNode == null){
            return head.next;
        }else if(targetSuperNode.next == null){
            return null;
        }else{
            targetSuperNode.next = queue.poll().next;
        }
        return head;
    }

    public static void main(String[] args) {
        //1
//        ListNode headNode = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        headNode.next = node1;
//        ListNode node2 = new ListNode(3);
//        node1.next = node2;
//        ListNode node3 = new ListNode(4);
//        node2.next = node3;
//        ListNode node4 = new ListNode(5);
//        node3.next = node4;
//        int n = 2;
        //null
        ListNode headNode = new ListNode(1);
        int n = 1;
        //1
//        ListNode headNode = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        headNode.next = node1;
//        int n = 2;
        RemoveNNodeV2 removeNNodeV2 = new RemoveNNodeV2();
        ListNode head = removeNNodeV2.removeNthFromEnd(headNode, n);
        System.out.println(head == null ? null :head.val);
    }
}
