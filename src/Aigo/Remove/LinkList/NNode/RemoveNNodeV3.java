package Aigo.Remove.LinkList.NNode;

import Aigo.POJO.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/18 14:13
 * @Version 1.0.0
 */
public class RemoveNNodeV3 extends RemoveNNodeSuper{
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<ListNode>();
        ListNode curNode = head;
        while(curNode != null){
            nodeList.add(curNode);
            curNode = curNode.next;
        }
        int index = nodeList.size() - n;
        if(index == 0){
            if(index == 1){
                return null;
            }else{
                return head.next;
            }
        }else{
            ListNode targetSuper = nodeList.get(index - 1);
            targetSuper.next = targetSuper.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        //1
        ListNode headNode = new ListNode(1);
        ListNode node1 = new ListNode(2);
        headNode.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        int n = 2;
        //null
//        ListNode headNode = new ListNode(1);
//        int n = 1;
        //1
//        ListNode headNode = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        headNode.next = node1;
//        int n = 1;
        RemoveNNodeV3 removeNNodeV3 = new RemoveNNodeV3();
        ListNode head = removeNNodeV3.removeNthFromEnd(headNode,n);
        System.out.println(head.val);
    }
}
