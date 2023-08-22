package aigo.reverse.Linked.List;

import aigo.POJO.ListNode;

import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:01
 * @Version 1.0.0
 */
public class ReverseLinkListV2 extends ReverseLinkedListSuper{
    /**
     *@Description 借助栈的先进后出的规则来实现
     *@Author zhangshenming
     *@Param head
     *@Date 2021/10/7 22:44
     *@Return boolean
     */
    public boolean isReversed(ListNode head){
        if(head == null){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }
        ListNode newNode = head;
        boolean flag = true;
        while(newNode != null){
            if(newNode.val == stack.pop()){
                newNode = newNode.next;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node1 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ReverseLinkListV1 reverseLinkListV1 = new ReverseLinkListV1();
        boolean flag = reverseLinkListV1.isReversed(head);
        System.out.println("该链表是回文链表：" + flag);
    }
}
